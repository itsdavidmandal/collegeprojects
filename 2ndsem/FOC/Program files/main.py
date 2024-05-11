import os
from datetime import datetime
from read import read_file
from operations import rent_land, return_land, display_available_lands, display_unavailable_lands

def contains_digits(s):
    """
    Function to check if a string contains any digits.
    """
    return any(char.isdigit() for char in s)

def main():
    lands = read_file("land.txt")
    while True:
        print("*" * 80)
        
        print("TechnoPropertyNepal Limited || Phone Number : +9779854024755 ")
        print("*" * 80)

        print("\n1. Display Available Lands")
        print("2. Rent Land")
        print("3. Return Land")
        print("4. Exit")
        print("=" * 80)
        try:
            choice = int(input("Enter your choice: "))
            if choice == 1:
                display_available_lands(lands)
            elif choice == 2:
                while True:
                    print("=" * 80)
                    customer_name = input("Enter customer name: ")
                    if not customer_name or contains_digits(customer_name):
                        print("Name cannot be empty or contain digits. Please try again.")
                        continue
                    customer_contact = input("Enter customer contact: ")
                    if not customer_contact.isdigit() or len(customer_contact) != 10:
                        print("Contact should be a 10-digit numeric value. Please try again.")
                        continue
                    customer_address = input("Enter customer address: ")
                    if not customer_address or contains_digits(customer_address):
                        print("Address cannot be empty or contain digits. Please try again.")
                        continue

                    customer_details = {
                        "Name": customer_name,
                        "Contact": customer_contact,
                        "Address": customer_address,
                        "Date": datetime.now().strftime("%Y-%m-%d %H:%M:%S")
                    }
                    rent_land(lands, customer_details)
                    break
            elif choice == 3:
                while True:
                    print("=" * 80)
                    customer_name = input("Enter customer name: ")
                    if not customer_name or contains_digits(customer_name):
                        print("Name cannot be empty or contain digits. Please try again.")
                        continue
                    customer_contact = input("Enter customer contact: ")
                    if not customer_contact.isdigit() or len(customer_contact) != 10:
                        print("Contact should be a 10-digit numeric value. Please try again.")
                        continue
                    customer_address = input("Enter customer address: ")
                    if not customer_address or contains_digits(customer_address):
                        print("Address cannot be empty or contain digits. Please try again.")
                        continue

                    customer_details = {
                        "Name": customer_name,
                        "Contact": customer_contact,
                        "Address": customer_address,
                        "Date": datetime.now().strftime("%Y-%m-%d %H:%M:%S")
                    }
                    return_land(lands, customer_details)
                    break
            elif choice == 4:
                print("=" * 80)
                print("Exiting program.")
                print("=" * 80)
                break
            else:
                print("=" * 80)
                print("Invalid choice. Please try again.")
                print("=" * 80)
        except ValueError:
            print("/" * 80)
            print("Invalid input. Please enter an integer choice.")
            print("/" * 80)

if __name__ == "__main__":
    main()
# if the code is run directly , then the main shall run
#if not then the function that is called shall run .

