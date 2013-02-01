package team08

class MakeEvent {
	NonMemberCustomer customer
	Employee employee
	String typere
	String idre
	String pricere
	String statusre
    static constraints = {
    	customer nullable:true
    	employee nullable:true
    	typere nullable:true
    	idre nullable:true
    	pricere nullable:true
    	statusre nullable:true
    }
}
