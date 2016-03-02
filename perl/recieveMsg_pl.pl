use experimental 'smartmatch';
use Google::Voice;



#Google login info
my $username    = 'abblueprint2k16@gmail.com';
my $password    = "abidealab";
 
 $num_args = $#ARGV + 1;
if ($num_args != 0) {
    print "\nUsage: recieveMsg.pl \n";
    exit;
}
unlink("C:\Users\Admin\Desktop\texts");
my $filename = 'C:\Users\Admin\Desktop\texts';

#Do Not Edit Below Here!
 
#create Google::Voice object and login

my $gv_obj = Google::Voice->new->login($username, $password);
 
 if($gv_obj == undef){
 
	print "LOGIN FAILED \n";
	exit;
 }
 
print "LOGIN SUCCESSFUL \n";

open(my $fh, '>', $filename) or die "Could not open file '$filename' $!";
 
 foreach my $sms ( $gv_obj->sms ) {

	foreach my $msg ($sms->messages){
	
		if($msg->outbound == "1"){
			print $fh $msg->text, "\n";
		}
		
		
	}
		

   $sms->delete;
}
close $fh;