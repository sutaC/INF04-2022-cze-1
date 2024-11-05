#!/bin/python
from random import randint

def search(arr: list[int], needle: int) -> int:
    arr.append(needle)
    for i in range(len(arr)):
        if arr[i] == needle:
            arr.pop()
            if i < len(arr):
                return i
            else:
                return -1

def fillRandom(arr: list[int]) -> None:
    for i in range(50):
        arr.append(randint(1, 100))

def displayArray(arr: list[int]) -> None:
    for item in arr:
        print(item, end=", ")
    print("")

# Start
print("Program szukający podanej liczby w losowej tablicy")
needle = None
while True:
    needle = input("Podaj liczbę do wyszukania: ")
    try:
        needle = int(needle)
    except:
        print("Nieprawidłowa wartość")
        continue
    break

array = list[int]()
fillRandom(array)
index = search(array, needle)
print("Losowa tablica: ")
displayArray(array)
if index < 0:
    print(f"Wartość {needle} nie została znaleziona")
else:
    print(f"Wartość {needle} została znaleziona na pozycji {index}")
