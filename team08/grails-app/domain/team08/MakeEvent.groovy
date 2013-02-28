package team08

class MakeEvent {
	MemberCustomer customer
	Employee employee
	String typere                  // TYPE OF ROOMEVENT
	String idre                    //  ID OF ROOMEVENT
	String pricere                 // Price Of ROOMEVENT
	String statusre                //  Status Of ROOMEVENT
    static constraints = {
    	customer nullable:true
    	employee nullable:true
    	typere nullable:true
    	idre nullable:true
    	pricere nullable:true
    	statusre nullable:true
    }
}
