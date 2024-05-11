import os
from datetime import datetime


def read_file(filename):

    """
This function essentially reads each line from the file, extracts land information,
creates a dictionary for each land, and appends it to a list.
Finally, it returns the list containing all the land dictionaries.
    """
    
    lands = [] #initialise an empty list to store infos
    with open(filename, 'r') as file:
        for line in file:
            data = line.strip().split(',') #split and store the info in the data bhane list
            print(data)  # Debug: Print data to check if it's read correctly
            land = {   # made a dict. known as land and data ko specific values haru specific keys lai assign gareko 
                "kitta_number": data[0],
                "city": data[1],
                "direction": data[2],
                "area": int(data[3]),
                "price": int(data[4]),
                "status": data[5]
            }
            lands.append(land) # land bhane dict. lai lands bhane list ma rakheko 
    return lands
