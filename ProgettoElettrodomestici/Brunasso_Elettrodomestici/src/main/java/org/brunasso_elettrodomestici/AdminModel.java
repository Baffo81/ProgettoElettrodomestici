package org.brunasso_elettrodomestici;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminModel {
    private Connection connection;
    private static AdminModel instance = null;

    public AdminModel() {
        // Modifica la connessione al database
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/elettrodomestici", "root", "Gaetano22");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static AdminModel getInstance() { // returns an instance or defines a new one if not exists already
        if(instance == null)
            instance = new AdminModel();
        return instance;
    }

    public void addProduct(String codice, String nome, String descrizione, String prezzo, String marca, String categoria, String quantita, String sconto, String fornitore) {
        String query = "INSERT INTO prodotti (codice, nome, descrizione, prezzo, marca, categoria, quantita, sconto, fornitore) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, codice);
            stmt.setString(2, nome);
            stmt.setString(3, descrizione);
            stmt.setDouble(4, Double.parseDouble(prezzo));
            stmt.setString(5, marca);
            stmt.setString(6, categoria);
            stmt.setInt(7, Integer.parseInt(quantita));
            stmt.setDouble(8, Double.parseDouble(sconto));
            stmt.setString(9, fornitore);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Errore durante l'inserimento del prodotto: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Errore nei formati numerici (prezzo, quantità o sconto): " + e.getMessage());
        }
    }
}
