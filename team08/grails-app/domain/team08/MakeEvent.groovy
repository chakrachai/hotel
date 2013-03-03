package team08

class MakeEvent {
    MemberCustomer customer
    Employee employee
    String typere                  // TYPE OF ROOMEVENT                   //  ID OF ROOMEVENT
    String pricere                 // Price Of ROOMEVENT
    String datere                  // Date For Check ON OR OFF
    static constraints = {
        customer nullable:true
        employee nullable:true
        typere nullable:true
        pricere nullable:true
        datere nullable:true
    }
}
