<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <%@ include file="../insert/headTemplate.jsp" %>
    <title>Informes</title>
    <link rel="stylesheet" href="<%=GlobalInfo.URL_PROYECTO%>/css/style_v2.css"/>
</head>

<body>
<div class="container">
    <%@ include file="../insert/header.jsp" %>
    <main>
        <%@ include file="../insert/mainNav.jsp" %>
        <div class="mainBlock">
            <div class="content">
                <h2>Filtro de fechas</h2>
                <form id="filterForm">
                    <label for="startDate">Fecha de inicio:</label>
                    <input type="date" id="startDate" name="startDate">
                    <label for="endDate">Fecha de fin:</label>
                    <input type="date" id="endDate" name="endDate">
                    <button type="submit">Filtrar</button>
                </form>

                <h2>Gastos</h2>
                <table id="expensesTable">
                    <thead>
                    <tr>
                        <th>Fecha</th>
                        <th>Descripción</th>
                        <th>Monto</th>
                    </tr>
                    </thead>
                    <tbody id="expensesBody">
                    <!-- Aquí se mostrarán los gastos filtrados por fecha -->
                    </tbody>
                </table>

                <h2>Ingresos</h2>
                <table id="incomeTable">
                    <thead>
                    <tr>
                        <th>Fecha</th>
                        <th>Descripción</th>
                        <th>Monto</th>
                    </tr>
                    </thead>
                    <tbody id="incomeBody">
                    <!-- Aquí se mostrarán los ingresos filtrados por fecha -->
                    </tbody>
                </table>
            </div>
        </div>
        <%@ include file="../insert/footer.jsp" %>
    </main>
</div>

<script>
    const filterForm = document.getElementById('filterForm');
    const expensesBody = document.getElementById('expensesBody');
    const incomeBody = document.getElementById('incomeBody');

    filterForm.addEventListener('submit', function(event) {
        event.preventDefault();

        const startDate = document.getElementById('startDate').value;
        const endDate = document.getElementById('endDate').value;

        // Aquí debes implementar la lógica para obtener los gastos e ingresos filtrados por fecha
        // Puedes hacer una solicitud AJAX a un servidor o utilizar datos en el lado del cliente

        // Ejemplo de cómo añadir datos a la tabla de gastos
        const expenseData = [
            { fecha: '2023-06-01', descripcion: 'Gasto 1', monto: 100 },
            { fecha: '2023-06-02', descripcion: 'Gasto 2', monto: 150 },
            { fecha: '2023-06-03', descripcion: 'Gasto 3', monto: 200 }
        ];

        expensesBody.innerHTML = '';
        expenseData.forEach(function(expense) {
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${expense.fecha}</td>
                <td>${expense.descripcion}</td>
                <td>${expense.monto}</td>
            `;
            expensesBody.appendChild(row);
        });

        // Ejemplo de cómo añadir datos a la tabla de ingresos
        const incomeData = [
            { fecha: '2023-06-01', descripcion: 'Ingreso 1', monto: 500 },
            { fecha: '2023-06-02', descripcion: 'Ingreso 2', monto: 300 },
            { fecha: '2023-06-03', descripcion: 'Ingreso 3', monto: 200 }
        ];

        incomeBody.innerHTML = '';
        incomeData.forEach(function(income) {
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${income.fecha}</td>
                <td>${income.descripcion}</td>
                <td>${income.monto}</td>
            `;
            incomeBody.appendChild(row);
        });
    });
</script>

</body>

</html>
