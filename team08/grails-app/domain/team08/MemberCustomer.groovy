package team08
class MemberCustomer {

	String fName			//ชื่อลูกค้า
	String mName			//ชื่อกลาง
	String lName			//นามสกุล
	String gender			//เพศสภาพ
	String born				//วันเกิด
	String age				//อายุ
	String nationality		//สัญชาติ
	String idCityzen		//รหัสประจำตัวประชาชน
	String address			//ที่อยู่ตามทะเบียนบ้าน
	String emailAddress		//อีเมลล์ที่ติดต่อได้
	String memberId			//รหัสลูกค้า
	String memberType		//ประเภทลูกค้า[normal,VIP]
	String telNo			// เบอร์โทร


    static constraints = {
    mName nullable:true
     fName blank:false			//ชื่อลูกค้า
				//ชื่อกลาง
	 lName blank:false			//นามสกุล
	 gender blank:false			//เพศสภาพ
	 born blank:false				//วันเกิด
	 age blank:false				//อายุ
	 nationality blank:false		//สัญชาติ
	 		//รหัสประจำตัวประชาชน
	 address blank:false			//ที่อยู่ตามทะเบียนบ้าน
	 emailAddress blank:false		//อีเมลล์ที่ติดต่อได้
	 memberId blank:false			//รหัสลูกค้า
	 memberType blank:false		//ประเภทลูกค้า[normal,VIP]
	 telNo blank:false			// เบอร์โทร
	 idCityzen  blank:false, unique:true, matches:/\d{13}/ 

    }
}