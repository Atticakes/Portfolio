#99 bottles of beer on the wall
#Loop till the end passage

print "I am a 'Bottle of Beer' Machine!"

drink = str(raw_input("Please tell me what drink you are having:"))
bottle = int(raw_input("Please tell me how many bottles you have:"))
start = bottle

while bottle >= 1:
    if bottle != 1:
        print bottle,"bottles of",drink,"on the wall,",bottle,"bottles of",drink,"."
    else:
        print bottle,"bottle of",drink,"on the wall,",bottle,"bottle of",drink,"."
    bottle -= 1
    if bottle != 0 and bottle != 1:
        print "Take one down, pass it around,",bottle,"bottles of",drink,"on the wall..."
    elif bottle == 1:
        print "Take one down, pass it around,",bottle,"bottle of",drink,"on the wall..."
    else:
        print "Take one down, pass it around, no more bottles of",drink,"on the wall..."

print "No more bottles of",drink,"on the wall, no more bottles of",drink,"."
print "Go to the store and buy some more,",start,"bottles of",drink,"on the wall..."