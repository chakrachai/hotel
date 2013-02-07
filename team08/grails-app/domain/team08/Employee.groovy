package team08

class Employee {
	String nameem
	String classem
	String idem
	String statusem
	static hasMany=[typeService:TypeService, monyService :MonyService , room:Room ,makeEvent:MakeEvent, timeWork:TimeWork]
    static constraints = {
    }
}
