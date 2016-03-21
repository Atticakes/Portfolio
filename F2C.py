#T(°C) = (T(°F) - 32) × 5/9
 
print "Hello, I am a temperature converter."
fahrenheit = int(raw_input("Please provide me with the Fahrenheit reading:"))
print "Thank you!"
print "I will not do some maths to convert",fahrenheit,"to Celsius."
print "Celsius =",fahrenheit,"- 32) x 5/9"
celsius = (fahrenheit - 32) * (5/9)
print fahrenheit,"degrees Fahrenheit =",celsius,"degrees Celsius!"