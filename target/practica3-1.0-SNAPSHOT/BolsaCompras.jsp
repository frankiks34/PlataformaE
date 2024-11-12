
    <%@page import="java.util.List"%>
<%@page import="Negocio.Curso"%>
<%@page import="Negocio.Curso"%>
<%@page import="Negocio.bolsa_Compras"%>
<%@page import="Negocio.Estudiante"%>
<% 
        HttpSession misession = request.getSession();
        Estudiante estudiante =(Estudiante)request.getSession().getAttribute("estudiante");

       if (estudiante==null) {
                response.sendRedirect("sinLogin.jsp");
            }
        bolsa_Compras a = (bolsa_Compras)request.getSession().getAttribute("bol");
        List<Curso> cursos = a.getCursos();


    %>

    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="Bolsa de Compras">
        <meta name="author" content="">
        <title>Bolsa de Compras - Plataforma de Cursos</title>
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="css/styles.css" rel="stylesheet">
    </head>
    <body>

<!-- Agregar el script de Stripe -->
<script src="https://js.stripe.com/v3/"></script>

<section class="page-section" id="checkout">
    <div class="container">
        <h2 class="section-heading text-uppercase">Completar Compra</h2>
        <p class="section-subheading text-muted">Introduce los datos de tu tarjeta para completar la compra.</p>
        
        
        <form id="payment-form">
            <div id="card-element"><!-- Aquí se inserta el campo de la tarjeta de Stripe --></div>
            <button id="submit" class="btn btn-primary mt-3">Pagar $<%= a.totalimporte() %></button>
            <div id="card-errors" role="alert"></div>
        </form>
    </div>
</section>
            </body>
 </html>
<script>
    const stripe = Stripe("pk_test_51QHIoWCWDkTOYdnt90rO05WyTXYKc7gUPYYWiqqFd2or03R55wYBfcl4UJHGh2xH7AOZonSm0HRct7Lf1BzpeSXu00F8mFmjZe"); // Agrega tu clave pública aquí
    const elements = stripe.elements();
    const cardElement = elements.create('card');

    cardElement.mount('#card-element');

    const form = document.getElementById('payment-form');
   form.addEventListener('submit', async (event) => {
    event.preventDefault();

    const {paymentMethod, error} = await stripe.createPaymentMethod({
        type: 'card',
        card: cardElement,
    });

    if (error) {
        document.getElementById('card-errors').textContent = error.message;
    } else {
        // Crear PaymentIntent con el método de pago
        const response = await fetch('ProcesarPagoServlet', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ paymentMethodId: paymentMethod.id, total: "<%= a.totalimporte() %>" })
        });

        const result = await response.json();
        if (result.success) {
            // Redirigir a CrearSuscyBole con los detalles de pago
           window.location.href = "CrearSuscyBole?paymentIntentId=" + result.paymentIntentId + "&paymentMethodId=" + paymentMethod.id + "&monto=" + result.total;
        } else {
            document.getElementById('card-errors').textContent = result.message;
        }
    }
});
</script>
