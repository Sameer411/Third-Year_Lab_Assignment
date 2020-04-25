#Lab Assignment on Unit IV and Unit V: (Mandatory Assignment)
#Use network simulator NS2 to implement:
#a. Monitoring traffic for the given topology
#b. Analysis of CSMA and Ethernet protocols
#c. Network Routing: Shortest path routing, AODV.
#d. Analysis of congestion control (TCP and UDP).

#Name:-Anuja Chandrashekhar Dixit.
#Class:-TE-A
#Roll. No:-21









#Create a simulator object
set ns [new Simulator]

#Define different colors for data flows (for NAM)
$ns color 1 Blue

#Open the NAM trace file
set nf [open out.nam w]
$ns namtrace-all $nf

# Open the trace file
set f [open tcp.tr w]
$ns trace-all $f

#Define a 'finish' procedure
proc finish {} {
    global ns nf f
    $ns flush-trace
    #Close the NAM trace file
    close $nf
    # Close the trace file
    close $f
    #Execute NAM on the trace file
    exec nam out.nam &
    exit 0
}

#Create three nodes
set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]

#Create links between the nodes
$ns duplex-link $n0 $n1 1Mb 50ms DropTail
$ns duplex-link $n1 $n2 100Kb 5ms DropTail

#Set Queue Size of link (n1-n2) to 10
$ns queue-limit $n1 $n2 10


#Give node position (for NAM)
$ns duplex-link-op $n0 $n1 orient right
$ns duplex-link-op $n1 $n2 orient right

#Monitor the queue for link (n1-n2). (for NAM)
$ns duplex-link-op $n1 $n2 queuePos 0.5

#Setup a TCP connection
set tcp [new Agent/TCP]
$tcp set class_ 1
$ns attach-agent $n0 $tcp
set sink [new Agent/TCPSink]
$ns attach-agent $n2 $sink
$ns connect $tcp $sink

#Setup a FTP over TCP connection
set ftp [new Application/FTP]
$ftp attach-agent $tcp

#Start and stop FTP
$ns at 0.5 "$ftp start"
$ns at 50.5 "$ftp stop"

#Call the finish procedure after 51 seconds of simulation time
$ns at 51.0 "finish"

#Run the simulation
$ns run








output=====
cd Desktop/
res@res-HP-280-G2-MT-Legacy:~/Desktop$ ns ns-tcp.tcl

=======================

