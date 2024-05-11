import os
from datetime import datetime
from read import read_file
from write import generate_invoice



def display_available_lands(lands):

    """
Filter out only the available lands from the
provided list of lands and prints out their information in a formatted manner.
    """
    print ("="*80)
    print("Available Lands:")
    print ("="*80)
    for land in lands:
        if land["status"] == "Available": #check if the value of the key "status" is available or not in the dict.
            #using string formatting to print the info
            # %s = string || %d = integer
            print("Kitta Number: %s, City: %s, Direction: %s, Area: %d, Price: %d" % (
                land["kitta_number"], land["city"], land["direction"], land["area"], land["price"]))
                # values to be placed/substituted into the placeholders in the format string.

def rent_land(lands, customer_details):
    """
Everything related to renting of the lands :
choosing available lands , specify rent areas, confirming thebrent , and generating the invoice 
    """
    available_lands = [land for land in lands if land["status"] == "Available"]
    #create a new list and include the lands with available status 
    if not available_lands:
        print ("/"*80)
        print("No lands available for rent.")
        print ("/"*80)
        return
    
    purchased_lands = []  # List to store the lands the user has bought
    while True: # loop until the user wants to cancel/complete the renting
        
        display_available_lands(lands)# calling the func. to display the lands 
        
        kitta_number = input("Enter the kitta number of the land you want to rent: ")
        for land in lands:
            if land["kitta_number"] == kitta_number and land["status"] == "Available": # validation gareko 
                kitta_area = land["area"] # area lai kitta area ma rakhne . 
                purchased_lands.append(land)  # Add the bought land to the list
                break
        else:
            print ("/"*80)
            print("Invalid kitta number. Please try again.")
            print ("/"*80)
            continue
        
        while True:
            rent_area = input("Enter the area you want to rent for this land: ")
            try:
                rent_area = int(rent_area)
                if rent_area != kitta_area: # acc. to question , land area = kitta area 
                    print("The rent area should be equal to the available area.")
                else:
                    break
            except ValueError:
                print ("/"*80)
                print("Invalid input. Please enter an integer for land area.")
                print ("/"*80)


            
        confirm = input("Do you want to proceed with the rent? (yes/no): ")
        if confirm.lower() == "yes":
            for land in lands:
                if land["kitta_number"] == kitta_number:
                    land["status"] = "Not Available"
                    with open("land.txt", "w") as f:
                        for land in lands:
                            f.write(",".join([land["kitta_number"], land["city"], land["direction"], str(land["area"]), str(land["price"]), land["status"]]) + "\n")
            total_rent = land["price"]
            # this line existed long ago , i had misunderstood the question , now that i have understood the question right ,
            # i have made changes to the line above but am afraid to delete the whole line incase the program crashes  :-)
            more_lands_available = any(land["status"] == "Available" for land in lands)
            if not more_lands_available:
                generate_invoice(customer_details, total_rent, "rent", purchased_lands)  # Pass purchased_lands to generate_invoice

                print("No more lands available for rent.")
                break
            
            while True:
                
                
                more_lands = input("Do you want to buy more land? (yes/no): ")
                if more_lands.lower() == "yes":
                    break
                
                elif more_lands.lower() == "no":
                    generate_invoice(customer_details, total_rent, "rent", purchased_lands)  # Pass purchased_lands to generate_invoice
                    print ("="*80)
                    print("Rent successful!")
                    print ("="*80)
                    break
                
                else:
                    print ("/"*80)
                    print("Invalid input. Please enter 'yes' or 'no'.")
                    print ("/"*80)
                    
            if more_lands.lower() == "no":
                    break
            
        elif confirm.lower() == "no":
            print ("/"*80)
            print("Have a nice day.")
            print ("/"*80)
            break # added 1016-m-6
        else:
                    print ("/"*80)
                    print("Invalid input. Please enter 'yes' or 'no'.")
                    print ("/"*80)
                    break
    

def return_land(lands, customer_details):
    
    no_available_lands = [land for land in lands if land["status"] == "Not Available"]
    #create a new list and include the lands with available status 
    if not no_available_lands:
        print ("/"*80)
        print("No lands available for return.")
        print ("/"*80)
        return
    returned_lands=[]
    while True:
        display_unavailable_lands(lands)
        kitta_number = input("Enter the kitta number of the land you want to return: ")
        for land in lands:
            if land["kitta_number"] == kitta_number and land["status"] == "Not Available":
                kitta_area = land["area"]
                returned_lands.append(land)
                break
        else:
            print ("/"*80)
            print("Invalid kitta number. Please try again.")
            print ("/"*80)
            continue
        while True:
            
            try:
                return_area = int(input("Enter the area you want to return for this land: "))
                return_area = int(return_area)
                if return_area != kitta_area:
                    print ("/"*80)
                    print("The return area should be equal to the land arae ")
                    print ("/"*80)
                else:
                    break
            except ValueError:
                print ("/"*80)
                print ("Invalid input. Please enter integer ")
                print ("/"*80)
            

        while True :
            try:
                rent_duration = int(input("Enter the rent duration in months: "))
                contract_duration = int(input("Enter the contract duration in months: "))
                break

            except ValueError:
                print ("/"*80)
                print("Invalid input. Please enter integers for rent duration and contract duration.")
                print ("/"*80)
                
                
   
        
            
        confirm = input("Do you want to proceed with the return? (yes/no): ")
        if confirm.lower() == "yes":
            land["status"] = "Available"
            with open("land.txt", "w") as f:
                for land in lands:
                    f.write(",".join([land["kitta_number"], land["city"], land["direction"], str(land["area"]), str(land["price"]), land["status"]]) + "\n")
            total_return = land["price"]
    
            if rent_duration > contract_duration:
                extra_month = rent_duration - contract_duration
                return_price = land["price"]*rent_duration
                return_fines = extra_month * land["price"] * 0.1
                
                # Adding a fine of 10% on the total rent cost
                total_return = return_price + return_fines
                
            more_lands_available_return = any(land["status"] == "Not Available" for land in lands)
            if not more_lands_available_return:
                generate_invoice(customer_details, total_return, "return", returned_lands)  # Pass purchased_lands to generate_invoice

                print("No more lands available for rent.")
                break
            while True:
                morelands = input("Do you want to return more lands ?")
                if morelands.lower()=="yes":
                    break
                elif morelands.lower()=="no":
                    
            
                    generate_invoice(customer_details, total_return, "return", returned_lands)
                    print ("="*80)
                    print("Land return successful!")
                    print ("="*80)
                    break
                else:
                    print ("/"*80)
                    print("Invalid input")
                    print ("/"*80)
            if morelands.lower()=="no":
                break
                    
        else:
            print ("/"*80)
            print("Return canceled.")
            print ("/"*80)
            break

def display_unavailable_lands(lands):
    """
Fliters out the unavailable land and prints them
    """
    print ("="*80)
    print("Unavailable Lands:")
    print ("="*80)
    for land in lands:
        if land["status"] == "Not Available":
            print("Kitta Number: %s, City: %s, Direction: %s, Area: %d, Price: %d" % (
                land["kitta_number"], land["city"], land["direction"], land["area"], land["price"]))

