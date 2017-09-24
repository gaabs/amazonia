package controllers;

import models.Facade;
import models.entities.Product;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.productlist;

import javax.inject.Inject;
import java.util.Set;

public class ProductsController extends Controller {

    private FormFactory formFactory;
    private Facade facade;

    @Inject
    public ProductsController(FormFactory formFactory) {
        this.formFactory = formFactory;
        facade = Facade.getInstance();
    }

    public Result list() {
        Set<Product> setOfProducts = facade.findAllProducts();
        return ok(productlist.render(setOfProducts));
    }

    public Result search(String name, String category) {
        Set<Product> setOfProducts = facade.findProducts(name, category);
        return ok(productlist.render(setOfProducts));
    }

    public Result showBlank() {
        Form<Product> productForm = formFactory.form(Product.class);
        return ok(views.html.createproduct.render(productForm));
    }

    public Result show(Integer id) {
        Product product = facade.findProductById(id);
        if (product == null) {
            return notFound("Product " + id + " does not exist.");
        }
        Form<Product> productForm = formFactory.form(Product.class);
        Form<Product> filledForm = productForm.fill(product);
        return ok(views.html.createproduct.render(filledForm));
    }

    public Result save() {
        Product product = formFactory.form(Product.class).bindFromRequest().get();
        facade.createProduct(product);
        return ok("Saved product: " + product);
    }

}
