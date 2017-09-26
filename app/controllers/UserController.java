package controllers;

import models.Facade;
import models.entities.User;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.userlist;

import javax.inject.Inject;
import java.util.Set;

public class UserController extends Controller {

    private FormFactory formFactory;
    private Facade facade;

    @Inject
    public UserController(FormFactory formFactory) {
        this.formFactory = formFactory;
        facade = Facade.getInstance();
    }

    public Result list() {
        Set<User> setOfUsers = facade.userList();
        return ok(userlist.render(setOfUsers));
    }

    public Result showBlank() {
        Form<User> userForm = formFactory.form(User.class);
        return ok(views.html.usercreate.render(userForm));
    }

    public Result show(String email) {
        User user = facade.findUserByEmail(email);
        if (user == null) {
            return notFound("User " + email + " does not exist.");
        }
        Form<User> userForm = formFactory.form(User.class);
        Form<User> filledForm = userForm.fill(user);
        return ok(views.html.usercreate.render(filledForm));
    }

    public Result save() {
        User user = formFactory.form(User.class).bindFromRequest().get();
        facade.createUser(user);
        return ok("Saved user: " + user);
    }

    public Result loginForm() {
        Form<User> userForm = formFactory.form(User.class);
        return ok(views.html.userlogin.render(userForm));
    }

    public Result login() {
        User user = formFactory.form(User.class).bindFromRequest().get();
        if (!facade.login(user)) {
            return notFound("User not found.");
        }

        return ok("Logged user: " + user);
    }

}
