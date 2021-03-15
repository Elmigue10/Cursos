def is_leap(year):

    a=year//4
    

    if(a*4==year):
        leap = True
    else:
        leap = False
    
    # Write your logic here
    
    return leap

print ("Ingrese un año del calendario")
year = int(input())
print(is_leap(year))
