
<%@ attribute name="tours" type="java.util.Collection" required="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="tour-table" align="center">
	<table border="2">
		<c:forEach items="${tours}" var="tour">
			<tr>
				<td>${tour.name}</td>
				<td>${tour.description}</td>

				<c:if test="${loggedInUser.role == 1}">
					<td>
						<form action="UpdateTour" method="GET">
							<div style="padding: 2px; margin: 2px" >
								<input type="submit" value="EDIT" />
							</div>
						</form>
					</td>
				</c:if>
			</tr>
		</c:forEach>
	</table>
</div>