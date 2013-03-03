package team08

class TypeService {
	Room room 					//ดึงเลขห้องออกมาระบุ
	MemberCustomer customer 	//ดึงชื่อของลูกค้า
	Employee employee 			//เอาไว้ดึงในfeatureสำหรับพนักงาน
	String servId 				//ลำดับบริการ
	String servType 			//ประเภทบริการ
	String servName 			//ชื่อเมนู
	String servCost 			//ราคา
    static constraints = {
    }
}
