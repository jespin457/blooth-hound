# Blooth Hound
Discovering the intricacies involved in path finding within a 2D grid.

Built with React and Redux, Django and DRF, PostgreSQL (via ElephantSQL), and Java.

Hosted by GitHub.

# What is this?
While playing Stardew Valley, I noticed that the pathfinding of the player character would sometimes be a bit "janky". Specifically when near a little pocket of terrain and setting your path across a barrier. In the example below, the "barrier" so to speak would be the river. Notice that the player dips into the little "pocket" before adjusting their path.

<img src="https://i.imgur.com/ox3MPyG.mp4" alt="Stardew Valley Pathfinding">

I can imagine the reason the player attempts to cross the barrier at first is because it does not "detect" any barrier until it is close enough (something like 2 blocks away). When it does see that the path is intraversable, it likely adjusts by following the edge of the barrier until it finds a more reasonable path to take--notice it doesn't just take a direct vertical path towards the target and then a horizontal path. The player moves vertically **until** a diagonal path would get it directly onto the desired space.

#So why look so deeply into this?
I find it interesting. That's all there really is to it.

#Where do you start then?
Well, I've started with making a SUPER basic pathfinding algorithm. It's written in Java (see the "algorithm" directory) and deals with a 2D-grid in which there are no "barriers" of any sort. Simple enough, right? Though even at this level, there is a bit of complexity. There first problem I had to deal with was: how do I design the board? For this first implementation, it was obvious to me to use an array of int arrays (int[][] grid). 
