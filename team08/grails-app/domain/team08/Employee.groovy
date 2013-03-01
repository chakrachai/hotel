package team08

class Employee {
	String nameem			//ชื่อพนักงาน
	String classem			//สาขางาน แม่บ้าน อื่นๆ
	String idem				//รหัสพนักงาน
	String statusem			//สถานะการทำงาน
	String lnameem			//นามสกุลพนักงาน
	String tel				//เบอร์โทร
	String address			//ที่อยู่พนักงาน หอ บ้าน 
	String numaddress		//เลขที่อยู่
	String district			//อำเภอ
	String subdistrict		//ตำบล
	String province			//จังหวัด
	String nprovince		//รหัสจังหวัด
	String idppem			//รหัสประชาชนพนักงาน
    String ageem            //อายุ
	static hasMany=[typeService:TypeService, monyService :MonyService , room:Room ,makeEvent:MakeEvent, timeWork:TimeWork]
    static constraints = {
    	nameem nullable:true
    	classem nullable:true
    	idem nullable:true
    	statusem nullable:true
    	lnameem nullable:true
    	tel nullable:true
    	address nullable:true
    	numaddress nullable:true
    	district nullable:true
    	subdistrict nullable:true
    	province nullable:true
    	nprovince nullable:true
    	idppem nullable:true
    }
}
