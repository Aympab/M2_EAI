/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.miseSousPresse.metier;

import fr.miage.millan.presse.sharedpubpresse.objects.Publicite;
import fr.miage.millan.presse.sharedredactionpresse.objects.Article;
import fr.miage.millan.presse.sharedvolume.objects.Volume;
import java.util.ArrayList;

/**
 *
 * @author aympa
 */
public final class SimulationStockage {

    private static final ArrayList<Publicite> pubsEnStock = new ArrayList<Publicite>();
    private static final ArrayList<Article> articlesEnStock = new ArrayList<Article>();
    private static final ArrayList<Volume> volumesEnStock = new ArrayList<Volume>();

    private static int idPub = 0;
    private static int idArt = 0;
    private static int idVol = 0;

    public static void ajouterPub(Publicite p) {
        p.setIdPub(idPub);
        idPub += 1;
        pubsEnStock.add(p);
    }

    public static void ajouterArticle(Article a) {
        a.setId(idArt);
        idArt += 1;
        articlesEnStock.add(a);
    }

    public static void ajouterVolume(Volume v) {
        v.setId(idVol);
        idVol += 1;
        volumesEnStock.add(v);
    }

    public static ArrayList<Article> getStockArticle() {
        return articlesEnStock;
    }

    public static ArrayList<Publicite> getStockPub() {
        return pubsEnStock;
    }

    public static ArrayList<Volume> getStockVolume() {
        return volumesEnStock;
    }
}
