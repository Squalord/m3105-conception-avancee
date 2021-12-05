package kebab;

import ingredients.*;
import org.junit.Before;
import org.junit.Test;

import static kebab.Kebabier.unKebab;
import static org.assertj.core.api.Assertions.assertThat;

public class KebabTest {

    public static final Tomate TOMATE = new Tomate();
    public static final Agneau AGNEAU = new Agneau();
    public static final Sauce SAUCE = new Sauce();
    public static final Oignon OIGNON = new Oignon();
    public static final Pain PAIN = new Pain();
    public static final Salade SALADE = new Salade();
    public static final Crevette CREVETTE = new Crevette();
    public static final Thon THON = new Thon();
    public static final Fromage FROMAGE = new Fromage();

    private Kebab kebabAgneau;
    private Kebab kebabVegetarien;
    private Kebab kebabCrevette;
    private Kebab kebabThon;

    @Before
    public void ConfectionnerLesKebabs() {

        kebabAgneau = unKebab()
                .avec(PAIN)
                .avec(OIGNON)
                .avec(SAUCE)
                .avec(AGNEAU)
                .avec(TOMATE)
                .preparerLeKebab();

        kebabVegetarien = unKebab()
                .avec(PAIN)
                .avec(OIGNON)
                .avec(SAUCE)
                .avec(SALADE)
                .avec(TOMATE)
                .preparerLeKebab();

        kebabCrevette = unKebab()
                .avec(PAIN)
                .avec(SAUCE)
                .avec(SALADE)
                .avec(TOMATE)
                .avec(CREVETTE)
                .avec(FROMAGE)
                .preparerLeKebab();

        kebabThon = unKebab()
                .avec(PAIN)
                .avec(SAUCE)
                .avec(SALADE)
                .avec(TOMATE)
                .avec(CREVETTE)
                .avec(FROMAGE)
                .preparerLeKebab();
    }

    @Test
    public void un_kebab_contient_tout_les_ingredients_ajoutes() {

        assertThat(kebabAgneau.listerLesIngredients()).containsExactly(
                PAIN, OIGNON, SAUCE, AGNEAU, TOMATE
        );
        assertThat(kebabVegetarien.listerLesIngredients()).containsExactly(
                PAIN, OIGNON, SAUCE, SALADE, TOMATE
        );
        assertThat(kebabCrevette.listerLesIngredients()).containsExactly(
                PAIN, SAUCE, SALADE, TOMATE, CREVETTE, FROMAGE
        );
        assertThat(kebabThon.listerLesIngredients()).containsExactly(
                PAIN, SAUCE, SALADE, TOMATE, THON, FROMAGE
        );
    }


}
