package team08
import org.zkoss.zk.ui.Executions

import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class ChkInMemberComposer extends GrailsComposer {

    def afterCompose = { window ->
        // initialize components here
alert("กรุณากรอกเลขบัตรประจำตัวประชาชน")
        $('#chkx').on('click',{
            def xec = $('#idx')[0].text
            
            def varx = MemberCustomer.findByIdCityzen($('#idx')[0].text)
            def forx = MemberCustomer.findAll()
            
        if(xec.size()==0||xec.size()!=13){
            alert("กรุณากรอกให้ถูกต้อง")
        } 
          
        else if(varx == null){
            alert("ไม่พบข้อมูล")}

        else{
                if(varx.memberType=="VIP MEMBER"){
                    $('#ck').setChecked(true)

                }
                        $('#idx').setText("")
                        $('#g1').setOpen(false)
                        $('#g2').setOpen(true)

                        $('#nx').setValue(varx.fName+"    "+varx.mName)
                        $('#lx').setValue(varx.lName)
                        $('#sx').setValue(varx.gender)
                        $('#bx').setValue(varx.born)
                        $('#ax').setValue(varx.age)
                        $('#nax').setValue(varx.nationality)
                        $('#adx').setValue(varx.address)
                        $('#mx').setValue(varx.emailAddress)
                        $('#ix').setValue(varx.memberId)
                        $('#cx').setValue(varx.telNo)
                        $('#tx').setValue(varx.memberType)
                    alert("เข็คอินสำเร็จ")
                       
                        
                }
        })

        $('#backx').on('click',{
            
            $('#ck').setChecked(false)
            $('#g2').setOpen(false)
            $('#g1').setOpen(true)
        })
    }
}

