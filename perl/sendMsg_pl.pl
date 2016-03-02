use experimental 'smartmatch';
use Google::Voice;
 
#Google login info
my $username    = 'abblueprint2k16@gmail.com';
my $password    = "abidealab";
 
 $num_args = $#ARGV + 1;
if ($num_args != 2) {
    print "\nUsage: senfMsg.pl NUMBER MESSAGE \n";
    exit;
}
 
#text message info
my $send_number = $ARGV[0];
my $send_text   = $ARGV[1];
 
#Do Not Edit Below Here!
 
#create Google::Voice object and login

my $gv_obj = Google::Voice->new->login($username, $password);
 
 if($gv_obj == undef){
 
	print "LOGIN FAILED \n";
	exit;
 }
print "LOGIN SUCCESSFUL \n";
#send the text!
$gv_obj->send_sms($send_number => $send_text);