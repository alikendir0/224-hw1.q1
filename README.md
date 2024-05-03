You are a tour guide in a coastal city and there are N islands and M undirected boat routes 
you need to organize in the country. Each island has a port and each port can work as layover. The 
port will be in two states, loading and running. In loading state, people get on the boats. In the 
running state, boats will leave the port for the next island. All the ports will switch their states from 
loading to running and vice versa after every T minutes. At a port, if its state is loading, you have 
to wait for it to switch its state to running. At the beginning, all the ports are in running state. The 
time taken to travel through any boat route is C minutes. Find the lexicographically smallest path 
which will take the minimum amount of time (in minutes) required to move from island X to island 
Y. 
In the input, the first line contains 4 space separated integers, N, M, T and C. N denotes the 
number of islands we have, M denotes the number of connections between the N islands, T denotes 
the time required by ports to change their states and C denotes that the time for traveling one island 
to another. Next M lines contain two space-separated integers each, U and V denoting that there is 
a bidirectional road between island U and island V. Next line contains two space-separated 
integers, X the island we start to travel and Y the island we want to reach at the end.
In the first line it is given that we have 5 islands and 5 bidirectional boat roads between 
them. For this case, time required the ports to change their state is 3 minutes and travel through 
any boat route is 5 minutes. The next lines gives the connections between the islands and the last 
line gives which island is the starting point and which island is the end point for this case.
>Sample Input: 

5 5 3 5 
1 2 
1 3 
2 4 
1 4 
2 5 
1 5 

In the output, the first line prints an integer K, denoting the number of islands you need to 
go through to reach island Y from the island X. In next line, print K space-separated integers 
denoting the path which will take the minimum amount of time (in minutes) required by to move 
from island X to island Y. In the last line, print the total time through the path from island X to 
island Y. There can be multiple paths. Print the lexicographically smallest one and then the total 
time for each path at the end. 
The output for the above inputs as follows. Please check your program with this input as 
well as the others that you will create. Please note that we may use other inputs when grading your 
assignments. 
>Sample Output: 

3 
1 2 5 
11 
