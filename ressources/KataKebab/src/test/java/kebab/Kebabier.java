package kebab;

import ingredients.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class Kebabier {

    List<Ingredient> ingredients;

    public Kebabier() {
        this.ingredients = new ArrayList<Ingredient>();
    }

    public static Kebabier unKebab() {
        return new Kebabier();
    }

    public Kebabier avec(Ingredient ingredient) {
        this.ingredients.add(ingredient);
        return this;
    }

    public Kebab preparerLeKebab() {
        return new Kebab(this.ingredients);
    }

}
