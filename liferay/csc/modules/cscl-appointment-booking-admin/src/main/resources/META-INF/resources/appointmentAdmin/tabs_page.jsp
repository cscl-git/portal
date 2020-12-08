<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<liferay-ui:tabs
    names='<%= "pending,approved,rejected,Appointee" %>'
    param="tabs2"
    refresh="<%= false %>"
    type="tabs nav-tabs-default"
>
    <liferay-ui:section>
        <%@ include file="/appointmentAdmin/pending_appointments.jsp" %>
    </liferay-ui:section>

    <liferay-ui:section>
        <%@ include file="/appointmentAdmin/completed_appointments.jsp" %>
    </liferay-ui:section>
     <liferay-ui:section>
        <%@ include file="/appointmentAdmin/rejected_appointments.jsp" %>
    </liferay-ui:section>
    <liferay-ui:section>
        <%@ include file="/appointmentAdmin/appointee_mapper.jsp" %>
    </liferay-ui:section>
     <!--<liferay-ui:section>
        <%@ include file="/appointmentAdmin/hold_appointments.jsp" %>
    </liferay-ui:section>-->
</liferay-ui:tabs>

