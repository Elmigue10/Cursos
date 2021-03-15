import math
import os
import random
import re
import sys


print("Ingrese un numero")

n = int(input().strip())

if(n<=5):
    if(n%2==0):
        print("Not Weird")
    else:
        print("Weird")

if(n>6):
    if(n<=20):
        print ("Weird")
    
    if(n>20):
        if(n%2==0):
                print("Not Weird")
        else:
            print("Weird")