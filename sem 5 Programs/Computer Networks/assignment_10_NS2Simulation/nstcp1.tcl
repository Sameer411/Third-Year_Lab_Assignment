#Lab Assignment on Unit IV and Unit V: (Mandatory Assignment)
#Use network simulator NS2 to implement:
#a. Monitoring traffic for the given topology
#b. Analysis of CSMA and Ethernet protocols
#c. Network Routing: Shortest path routing, AODV.
#d. Analysis of congestion control (TCP and UDP).
#Name:-Anuja Chandrashekhar Dixit.
#Class:-TE-A
#Roll. No:-21





set ns [new Simulator]


$ns color 1 Blue


set nf [open out.nam w]
$ns namtrace-all $nf


set f [open tcp.tr w]
$ns trace-all $f


proc finish {} {
    global ns nf f
    $ns flush-trace
 
    close $nf
    
    close $f
   
    exec nam out.nam &
    exit 0
}


set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]


$ns duplex-link $n0 $n1 1Mb 50ms DropTail
$ns duplex-link $n1 $n2 100Kb 5ms DropTail


$ns queue-limit $n1 $n2 10



$ns duplex-link-op $n0 $n1 orient right
$ns duplex-link-op $n1 $n2 orient right


$ns duplex-link-op $n1 $n2 queuePos 0.5


set tcp [new Agent/TCP]
$tcp set class_ 1
$ns attach-agent $n0 $tcp
set sink [new Agent/TCPSink]
$ns attach-agent $n2 $sink
$ns connect $tcp $sink


set ftp [new Application/FTP]
$ftp attach-agent $tcp


$ns at 0.5 "$ftp start"
$ns at 50.5 "$ftp stop"


$ns at 60.0 "finish"


$ns run








output=====
cd Desktop/
res@res-HP-280-G2-MT-Legacy:~/Desktop$ ns ns-tcp.tcl

=======================

