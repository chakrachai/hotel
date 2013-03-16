package team08

class MakeEventCustomer {
	MemberCustomer customerc
	String typerec
	String pricerec
	String daterec
	String dateresendc
    static constraints = {
    	customerc nullable:true
        typerec nullable:true
    	pricerec nullable:true
    	daterec nullable:true
    	dateresendc nullable:true
    }
}
