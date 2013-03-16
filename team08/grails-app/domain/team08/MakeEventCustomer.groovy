package team08

class MakeEventCustomer {
	MemberCustomer customer
	String typere
	String pricere
	String datere
	String dateresend
    static constraints = {
    	customer nullable:true
        typere nullable:true
    	pricere nullable:true
    	datere nullable:true
    	dateresend nullable:true
    }
}
