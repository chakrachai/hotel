package team08

import org.zkoss.zk.grails.composer.*
import org.zkoss.zk.ui.Executions

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class CheckdateComposer extends GrailsComposer {

    def afterCompose = { window ->
    	$('#listcheckmanager > listitem > listcell').detach()
            def kk = Employee.findAll()
            $('#listcheckmanager').append {
                for(c in kk) {
                    def s = TimeWork.findByEmployee(c)
                    listitem(value: c) {
                        listcell(label: c.idem)
                        listcell(label: c.nameem)
                        listcell(label: c.lnameem)
                        listcell(label: s.timein)
                        listcell(label: s.timeout)
                        listcell(label: c.classem)
                    }
                    
                }
            }

        $('#btnrefresh').on('click',{
            $('#listcheckmanager > listitem > listcell').detach()
            def j = Employee.findAll()
            $('#listcheckmanager').append {
                for(c in j) {
                    def s = TimeWork.findByEmployee(c)
                    listitem(value: c) {
                        listcell(label: c.idem)
                        listcell(label: c.nameem)
                        listcell(label: c.lnameem)
                        listcell(label: s.timein)
                        listcell(label: s.timeout)
                        listcell(label: c.classem)
                    }
                    
                }
            }
        	})
        $('#btnback').on('click',{
            Executions.sendRedirect("/index.zul")
            

            })
    }
}
