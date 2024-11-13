    package Negocio;

    import com.stripe.model.PaymentIntent;
    import com.stripe.exception.StripeException;
    import java.util.Arrays;

    import java.util.HashMap;
    import java.util.Map;

    public class PagoService {

        public PaymentIntent crearPaymentIntentConReturnUrl(String paymentMethodId, double total) throws StripeException {
              long amount = (long) (total * 100); 
            Map<String, Object> params = new HashMap<>();
            params.put("amount", amount);
            params.put("currency", "usd");
             params.put("payment_method", paymentMethodId);
                 params.put("confirm", true);
            params.put("return_url", "https://tu-sitio.com/confirmacion-pago");

           
            return PaymentIntent.create(params);
        }
    }
