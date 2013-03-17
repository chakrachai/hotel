package team08

import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class RoomReservationComposer extends GrailsComposer {

    def afterCompose = { window ->
    	int sa

    	def customer = MemberCustomer.findById("1")
    	//alert(customer.memberId)
    	$('#customerid')[0].text = customer.memberId
    	$('#customername')[0].text  = customer.fName
    	$('#customerlname')[0].text = customer.lName
    	$('#customernation')[0].text = customer.nationality
    	$('#customeremail')[0].text = customer.emailAddress
    	$('#customerphone')[0].text = customer.telNo

    	$('#reservation').on('click',{
    		if($('#customerMany')[0].text=="จำนวน"){
                sa =1
            }else{
              sa = Integer.parseInt($('#customerMany')[0].text)
            }
    		def roonreservation = new Room(
            roomNo : $('#room')[0].text,
            roomflore : $('#classRoom')[0].text,
            dayIn : $('#dayin')[0].text+" "+$('#mountin')[0].text+" "+$('#yearin')[0].text,
            dayOut : $('#dayout')[0].text+" "+$('#mountout')[0].text+" "+$('#yearout')[0].text,
            roomStatus: "จอง",
            customermany:sa,
            customer:customer,
            employee:null
        ).save()
    		alert("save")
		    if($('#roomList')!=null)
		        $('#roomList > listitem').detach()
		    for (dataroom in Room.findAllByCustomer(customer)){         
		        if(dataroom.roomStatus!="ว่าง"){
		            $('#roomList').append { 
		                listitem(value:dataroom){
		                    listcell{   
		                        label(value:dataroom.roomflore)
		                    }
		                    listcell{   
		                        label(value:dataroom.roomNo)
		                    }
		                    listcell{   
		                        label(value:dataroom.dayIn)
		                    }
		                    listcell{   
		                        label(value:dataroom.dayOut)
		                    }
		                    listcell{   
		                        label(value:dataroom.roomStatus)
		                    }

		                }
		            }
		        }

		    }
    	})

        $('#classRoom').on('select',{
                $('#room').append{
                    for(int count=1;count<=30;count++)
                    if(count<=9){
                            comboitem(label:$('#classRoom')[0].text+"0"+count)
                    }else{
                            comboitem(label:$('#classRoom')[0].text+count)
                    }
             }
        })
//=====================================================================================selectClassfore===========================
	$('#dayout').append{
            for(int count=1;count<=31;count++){
                comboitem(label:""+count)
            }                        
        }
        $('#mountout').append{
            comboitem(label:"มกราคม")
            comboitem(label:"กุมภาพันธ์")
            comboitem(label:"มีนาคม")
            comboitem(label:"เมษายน")
            comboitem(label:"พฤษภาคม")
            comboitem(label:"มิถุนายน")
            comboitem(label:"กรกฏาคม")
            comboitem(label:"สิงหาคม")
            comboitem(label:"กันยายน")
            comboitem(label:"ตุลาคม")
            comboitem(label:"พฤศจิกายน")
            comboitem(label:"ธันวาคม")
        }
        $('#yearout').append{
            for(int count=2550;count<=3000;count++){
                comboitem(label:""+count)
            }                        
        }
        $('#mountout').on('select',{
            $('#dayout > comboitem').detach()
            $('#mountout').append{
            comboitem(label:"มกราคม")
            comboitem(label:"กุมภาพันธ์")
            comboitem(label:"มีนาคม")
            comboitem(label:"เมษายน")
            comboitem(label:"พฤษภาคม")
            comboitem(label:"มิถุนายน")
            comboitem(label:"กรกฏาคม")
            comboitem(label:"สิงหาคม")
            comboitem(label:"กันยายน")
            comboitem(label:"ตุลาคม")
            comboitem(label:"พฤศจิกายน")
            comboitem(label:"ธันวาคม")
        }
        $('#yearout').append{
            for(int count=2550;count<=3000;count++){
                comboitem(label:""+count)
            }                        
        }
            String s =$('#mountout')[0].text
            if(s=="มกราคม" || s== "มีนาคม" || s== "พฤษภาคม" || s== "กรกฏาคม" || s== "สิงหาคม" || s== "ตุลาคม" || s== "ธันวาคม"){
                $('#dayout').append{
                    for(int count=1;count<=31;count++){
                        comboitem(label:""+count)
                    }                        
                }
                if($('#dayout')[0].text == "วัน"){
                    $('#dayout')[0].text ="วัน"
                }
                else if(Integer.valueOf($('#dayout')[0].text)>=31){
                    $('#dayout')[0].text ="31"
                }else {
 
                }
            }else if (s=="เมษายน" || s== "มิถุนายน" || s== "กันยายน" || s== "พฤศจิกายน"){
                $('#dayout').append{
                    for(int count=1;count<=30;count++){
                        comboitem(label:""+count)
                    }                        
                }
                if($('#dayout')[0].text == "วัน"){
                    $('#dayout')[0].text ="วัน"
                }
                else if(Integer.valueOf($('#dayout')[0].text)>=30){
                    $('#dayout')[0].text ="30"
                }else {
 
                }
            }else if(s=="กุมภาพันธ์"){
                int time
                if($('#yearout')[0].text=="ปี"){
                   time=Integer.parseInt(new Date().format("yyyy"))
                }else{
                    time = Integer.parseInt($('#yearout')[0].text)-543    
                }
                if(time%4==0){
                    $('#dayout').append{
                        for(int count=1;count<=29;count++){
                            comboitem(label:""+count)
                        }                        
                    }
                        if($('#dayout')[0].text == "วัน"){
                            $('#dayout')[0].text ="วัน"
                        }
                        else if(Integer.valueOf($('#dayout')[0].text)>=29){
                            $('#dayout')[0].text ="29"
                            alert("31")
                        }else {
         
                        }
                    }else{
                        $('#dayout').append{
                            for(int count=1;count<=28;count++){
                                comboitem(label:""+count)
                            }                        
                        }
                        if($('#dayout')[0].text == "วัน"){
                            $('#dayout')[0].text ="วัน"
                        }
                        else if(Integer.valueOf($('#dayout')[0].text)>=28){
                            $('#dayout')[0].text ="28"
                        }else {
         
                        }
                    }
            }else{
                alert("Error")
            }
        })
//===============================================================================================outTime================================================================
    $('#dayin').append{
            for(int count=1;count<=31;count++){
                comboitem(label:""+count)
            }                        
        }
        $('#mountin').append{
            comboitem(label:"มกราคม")
            comboitem(label:"กุมภาพันธ์")
            comboitem(label:"มีนาคม")
            comboitem(label:"เมษายน")
            comboitem(label:"พฤษภาคม")
            comboitem(label:"มิถุนายน")
            comboitem(label:"กรกฏาคม")
            comboitem(label:"สิงหาคม")
            comboitem(label:"กันยายน")
            comboitem(label:"ตุลาคม")
            comboitem(label:"พฤศจิกายน")
            comboitem(label:"ธันวาคม")
        }
        $('#yearin').append{
            for(int count=Integer.parseInt(new Date().format("yyyy"))+543;count<=3000;count++){
                comboitem(label:""+count)
            }                        
        }
        $('#mountin').on('select',{
            $('#dayin > comboitem').detach()
            $('#mountin').append{
            comboitem(label:"มกราคม")
            comboitem(label:"กุมภาพันธ์")
            comboitem(label:"มีนาคม")
            comboitem(label:"เมษายน")
            comboitem(label:"พฤษภาคม")
            comboitem(label:"มิถุนายน")
            comboitem(label:"กรกฏาคม")
            comboitem(label:"สิงหาคม")
            comboitem(label:"กันยายน")
            comboitem(label:"ตุลาคม")
            comboitem(label:"พฤศจิกายน")
            comboitem(label:"ธันวาคม")
        }
        $('#yearin').append{
            for(int count=Integer.parseInt(new Date().format("yyyy"))+543;count<=3000;count++){
                comboitem(label:""+count)
            }                        
        }
            String s =$('#mountin')[0].text
            if(s=="มกราคม" || s== "มีนาคม" || s== "พฤษภาคม" || s== "กรกฏาคม" || s== "สิงหาคม" || s== "ตุลาคม" || s== "ธันวาคม"){
                $('#dayin').append{
                    for(int count=1;count<=31;count++){
                        comboitem(label:""+count)
                    }                        
                }
                if($('#dayin')[0].text == "วัน"){
                    $('#dayin')[0].text ="วัน"
                }
                else if(Integer.valueOf($('#dayin')[0].text)>=31){
                    $('#dayin')[0].text ="31"
                }else {
 
                }
            }else if (s=="เมษายน" || s== "มิถุนายน" || s== "กันยายน" || s== "พฤศจิกายน"){
                $('#dayin').append{
                    for(int count=1;count<=30;count++){
                        comboitem(label:""+count)
                    }                        
                }
                if($('#dayin')[0].text == "วัน"){
                    $('#dayin')[0].text ="วัน"
                }
                else if(Integer.valueOf($('#dayin')[0].text)>=30){
                    $('#dayin')[0].text ="30"
                }else {
 
                }
            }else if(s=="กุมภาพันธ์"){
                int time
                if($('#yearin')[0].text=="ปี"){
                   time=Integer.parseInt(new Date().format("yyyy"))
                }else{
                    time = Integer.parseInt($('#yearin')[0].text)-543    
                }
                if(time%4==0){
                    $('#dayin').append{
                        for(int count=1;count<=29;count++){
                            comboitem(label:""+count)
                        }                        
                    }
                        if($('#dayin')[0].text == "วัน"){
                            $('#dayin')[0].text ="วัน"
                        }
                        else if(Integer.valueOf($('#dayin')[0].text)>=29){
                            $('#dayin')[0].text ="29"
                            alert("31")
                        }else {
         
                        }
                    }else{
                        $('#dayin').append{
                            for(int count=1;count<=28;count++){
                                comboitem(label:""+count)
                            }                        
                        }
                        if($('#dayin')[0].text == "วัน"){
                            $('#dayin')[0].text ="วัน"
                        }
                        else if(Integer.valueOf($('#dayin')[0].text)>=28){
                            $('#dayin')[0].text ="28"
                        }else {
         
                        }
                    }
            }else{
                alert("Error")
            }
        })
//==================================================================================timein===========================
    }
}
