Semi-Complete:
GameEngine - Other states need to be implemented. Follow syntax of CombatState as a guide to creating GameStates. I'll try and get that done over the weekend. Ideally we want an init state, normative state, combat state (already implemented), and a few conditional states (like player is dead, opponent is dead, etc.)

Party - .attack(Character opponent) needs to be implemented. For this, it would be best to make a sort of hybrid between Player.attack(Character opponent) and BadGuy.attack(Character opponent), i.e. apply damage similar to how damage is applied in the Communicator.playerAttack(...) method, but with the looseness of the Communicator.applyDamage(...) method. Also, at least 2 more Party subclassess should be added as well as a GenericPartyMember subclass of Party (follow syntax of GenericPlayer as a guide). MOST methods have already been abstracted out so adding a new class shouldn't be difficult, only a constructor should need to be implemented and the .displayStats() method. For now I just put a default statement in each one.

Item/Inventory - Since this was/is your job, I just made a very basic one which you may or may not want to use. Changing things around shouldn't be too difficult, but who knows, this part is up to you. If you want to use mine, the code is fairly self explanatory so adding new items and whatnot should not be very hard.

Complete:
Everything not mentioned above (with a few exceptions). That being said however, code modification will be necessary in order to get my code working with yours. Best of luck with this. I tried to make my code as verbose as possible so things could easily be understood, but please email me if you have questions. With the verbosity of it, integrating should be relatively easy.

Incomplete/needs to be started:
UML diagrams - will be done this weekend, likely saturday or as soon as I finish the GameEngine class. I'll email it to you when I have it done.
 
Testing - while this code compiles, I haven't had time to fully test it. It should all work correctly, but as with every piece of software you write, there are bound to be some bugs. If you find some, please try to fix them on your own as I'm very busy with the research internship. I've spent many long nights getting these classes thrown together, so I don't have much time to devote to debugging/fixing code. That being said, I'll still help whenever possible.
 
Demonstration - We need to get something demonstratable running, even if we don't have a spiffy menu or map, could be just something as simple as generating a random character, showing interaction with said character, and continuation of this until the user enters some exit keyword, like "exit" or "quit" or whatever.

Anyways, the project is now in your hands to finish up and I trust that you will and I wish you the best of luck.

-Turner
