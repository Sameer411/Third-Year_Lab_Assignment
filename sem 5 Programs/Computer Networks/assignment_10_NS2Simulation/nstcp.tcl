#Lab Assignment on Unit IV and Unit V: (Mandatory Assignment)
#Use network simulator NS2 to implement:
#a. Monitoring traffic for the given topology
#b. Analysis of CSMA and Ethernet protocols
#c. Network Routing: Shortest path routing, AODV.
#d. Analysis of congestion control (TCP and UDP).

#Name:-Anuja Chandrashekhar Dixit.
#Class:-TE-A
#Roll. No:-21








set ns [new Simulator]        #create simulator object
$ns color 1 Blue              #animation color


set nf [open out.nam w]        # opening of NAM trace file
$ns namtrace-all $nf            


set f [open tcp.tr w]          # trace file open
$ns trace-all $f

#Define a 'finish' procedure
proc finish {} {
    global ns nf f
    $ns flush-trace
   
    close $nf                   #closing of NAM trace file
   
    close $f                    # NAM trace file close
   
    exec nam out.nam &          #execution of trace file
    exit 0
}

#create 3 nodes
set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]


#creation of links between nodes
$ns duplex-link $n0 $n1 1Mb 50ms DropTail
$ns duplex-link $n1 $n2 100Kb 5ms DropTail



$ns queue-limit $n1 $n2 10    #queue Size of link (n1-n2) = 10


#node position 
$ns duplex-link-op $n0 $n1 orient right
$ns duplex-link-op $n1 $n2 orient right

#queue for link (n1-n2)
$ns duplex-link-op $n1 $n2 queuePos 0.5

#setup TCP connectiom
set tcp [new Agent/TCP]
$tcp set class_ 1
$ns attach-agent $n0 $tcp
set sink [new Agent/TCPSink]
$ns attach-agent $n2 $sink
$ns connect $tcp $sink

#Setup FTP over TCP connection
set ftp [new Application/FTP]
$ftp attach-agent $tcp

#Start and stop FTP
$ns at 0.5 "$ftp start"
$ns at 50.5 "$ftp stop"

#finish procedure after 51 seconds of simulation time
$ns at 60.0 "finish"

#Run the simulation
$ns run













