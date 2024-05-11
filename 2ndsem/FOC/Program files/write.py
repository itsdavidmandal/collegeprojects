import os
from datetime import datetime
from read import read_file



def generate_invoice(customer_details, total_rent, transaction_type, purchased_lands=None):
    """
Function to generate an invoice 
    """
    if not os.path.exists("invoices"):
        os.makedirs("invoices")
    timestamp = datetime.now().strftime("%Y%m%d%H%M%S")
    invoice_number = "INV-%s-%s"%(transaction_type, timestamp)
  


    kitta_numbers = []
    total_area = 0

    if purchased_lands is not None: #if the lands were bought then the kitta number and the total area is updated 
        for land in purchased_lands:
            kitta_numbers.append(land["kitta_number"])
            total_area += land["area"]

    invoice_data = {
        "invoice_number": invoice_number,
        "customer_details": customer_details,
        "transaction_type": transaction_type,
        "kitta_numbers": kitta_numbers,
        "total_area": total_area,
        "total_cost": total_rent
    }

    print("Invoice Number:", invoice_number)
    print("Customer Details:")
    print("\tName:", customer_details["Name"])
    print("\tContact:", customer_details["Contact"])
    print("\tAddress:", customer_details["Address"])
    print("Transaction Details:")
    print("\tTransaction Type:", transaction_type)
    print("\tKitta Numbers:", ", ".join(kitta_numbers))
    print("\tTotal Area:", total_area)
    print("\tTotal Cost:", total_rent)
    
    with open("invoices/%s-%s.txt"%(transaction_type, invoice_number), "w") as invoice_file:
        invoice_file.write("Invoice Number: %s\n" % (invoice_number))
        invoice_file.write("Customer Details:\n")
        invoice_file.write("\tName: %s\n" % (customer_details["Name"]))
        invoice_file.write("\tContact: %s\n" % (customer_details["Contact"]))
        invoice_file.write("\tAddress: %s\n" % (customer_details["Address"]))
        invoice_file.write("\n")
        invoice_file.write("Transaction Details:\n")
        invoice_file.write("\tTransaction Type: %s\n" % (transaction_type))
        invoice_file.write("\tKitta Numbers: %s\n" % (", ".join(kitta_numbers)))
        invoice_file.write("\tTotal Area: %d\n" % (total_area))
        invoice_file.write("\tTotal Cost: %d\n" % (total_rent))

    print("Invoice generated: invoices/%s-%s.txt" % (transaction_type, invoice_number))

