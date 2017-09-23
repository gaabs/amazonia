package controllers;

import models.Facade;
import models.entities.User;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.showuser;
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
        return ok(showuser.render(userForm));
    }

    public Result show(Integer id) {
        User user = facade.findUserById(id);
        if (user == null) {
            return notFound("User " + id + " does not exist.");
        }
        Form<User> userForm = formFactory.form(User.class);
        Form<User> filledForm = userForm.fill(user);
        return ok(showuser.render(filledForm));
    }

    public Result save() {
        User user = formFactory.form(User.class).bindFromRequest().get();
        facade.createUser(user);
        return ok("Saved user: " + user);
    }

}
