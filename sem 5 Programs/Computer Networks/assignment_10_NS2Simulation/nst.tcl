#Lab Assignment on Unit IV and Unit V: (Mandatory Assignment)
#Use network simulator NS2 to implement:
#a. Monitoring traffic for the given topology
#b. Analysis of CSMA and Ethernet protocols
#c. Network Routing: Shortest path routing, AODV.
#d. Analysis of congestion control (TCP and UDP).

#Name:-Anuja Chandrashekhar Dixit.
#Class:-TE-A
#Roll. No:-21


set ns [new simulator] //create simulator

$ns color 1 Blue //color of packet

set nf [open out.nam w]
$ns namtrace-all $nf
