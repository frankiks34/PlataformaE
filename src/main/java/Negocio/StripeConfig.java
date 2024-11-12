package Negocio;

import com.stripe.Stripe;

public class StripeConfig {
    
    
    public static void initialize() {
        // Coloca aquí tu clave secreta de Stripe
        Stripe.apiKey = "sk_test_51QHIoWCWDkTOYdntfPWFs3csJDa4lgWMyrhteqcjM85IefoMG0tXZJc1bXdgbQYrc08A1qc2LuKHe4sRquPTHjhL00pqv0Bbs2";
    }
}
