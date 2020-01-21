/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.broker;

import database.connection.ConnectionFactory;
import domain.IDomainObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nemanja
 */
public class DatabaseBroker {

    /*public IDomainObject save(IDomainObject domainObject) throws SQLException {
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO ")
                    .append(domainObject.getTableName())
                    .append(" (").append(domainObject.getAllColumnNames()).append(")")
                    .append(" VALUES (")
                    .append(domainObject.getValuesForInsert())
                    .append(")");
            String query = sb.toString();
            System.out.println(query);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                Long id = rs.getLong(1);
                domainObject.setId(id);
            }
            //connection.commit();
            statement.close();
            return domainObject;

        } catch (SQLException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        }
    }
     */
    public IDomainObject save2(IDomainObject domainObject) throws Exception {
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            sb.append("INSERT INTO ")
                    .append(domainObject.getTableName())
                    .append(" (").append(domainObject.getAllColumnNames()).append(")")
                    .append(" VALUES (")
                    .append(domainObject.getValuesForInsert())
                    .append(")");
            String query = sb.toString();
            System.out.println(query);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                Long id = rs.getLong(1);
                domainObject.setId(id);
                for (int j = 0; j < domainObject.vratiBrojVezanihObjekata(); j++) {
                    IDomainObject vezo = null;
                    //vezo.setId(id);
                    for (int i = 0; i < domainObject.vratiBrojSlogovaVezanogObjekta(j); i++) {
                        vezo = domainObject.vratiSlogVezanogObjekta(j, i);
                        vezo.setId(id);
                        sb2.append("INSERT INTO ")
                                .append(vezo.getTableName())
                                .append(" (").append(vezo.getAllColumnNames()).append(")")
                                .append(" VALUES (")
                                .append(vezo.getValuesForInsert())
                                .append(")");
                        String query1 = sb2.toString();
                        System.out.println(query1);
                        statement = connection.createStatement();
                        statement.executeUpdate(query1);
                        //isprazniti string builder
                        sb2.setLength(0);
                    }
                }
            }
            //connection.commit();
            statement.close();
            return domainObject;

        } catch (SQLException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void delete(IDomainObject domainObject) throws Exception {
        Connection connection = ConnectionFactory.getInstance().getConnection();
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM ")
                .append(domainObject.getTableName())
                .append(" WHERE ")
                .append(domainObject.getKeyName())
                .append(" = ")
                .append(domainObject.getKeyValue());
        String query = sb.toString();
        System.out.println(query);

        Statement statement = connection.createStatement();
        statement.executeUpdate(query);

        //connection.commit();
        statement.close();

    }

    public IDomainObject update(IDomainObject domainObject) throws Exception {
        Connection connection = ConnectionFactory.getInstance().getConnection();
        Statement statement;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (domainObject.vratiBrojVezanihObjekata() == 0) {
            sb.append("UPDATE ")
                    .append(domainObject.getTableName())
                    .append(" SET ")
                    .append(domainObject.getColumnNameAndValuesForUpdate())
                    .append(" WHERE ")
                    .append(domainObject.getKeyName())
                    .append(" = ")
                    .append(domainObject.getKeyValue());
            String query = sb.toString();
            System.out.println(query);

            statement = connection.createStatement();
            statement.executeUpdate(query);
        }else{
            for (int j = 0; j < domainObject.vratiBrojVezanihObjekata(); j++) {
                    IDomainObject vezo = domainObject.vratiVezaniObjekat(j);
                    vezo.setId(Long.parseLong(domainObject.getKeyValue()));
                    delete(vezo);
                    //vezo.setId(id);
                    for (int i = 0; i < domainObject.vratiBrojSlogovaVezanogObjekta(j); i++) {
                        vezo = domainObject.vratiSlogVezanogObjekta(j, i);
                        vezo.setId(Long.parseLong(domainObject.getKeyValue()));
                        sb2.append("INSERT INTO ")
                                .append(vezo.getTableName())
                                .append(" (").append(vezo.getAllColumnNames()).append(")")
                                .append(" VALUES (")
                                .append(vezo.getValuesForInsert())
                                .append(")");
                        String query1 = sb2.toString();
                        System.out.println(query1);
                        statement = connection.createStatement();
                        statement.executeUpdate(query1);
                        //isprazniti string builder
                        sb2.setLength(0);
                    }
                }
        }

        return domainObject;

    }

    public List<IDomainObject> getAll(IDomainObject domainObject) throws Exception {
        //List<IDomainObject> objects = new ArrayList<>();
        Connection connection = ConnectionFactory.getInstance().getConnection();
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT *")
                .append(" FROM ")
                .append(domainObject.getTableName());

        if (domainObject.vratiBrojVezanihObjekata() > 0) {
            sb.append(domainObject.vratiJoinUslov());
        }

        String query = sb.toString();
        System.out.println(query);

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);

        List<IDomainObject> objects = domainObject.napraviListu(rs);

        return objects;

    }

    public IDomainObject getOne(IDomainObject domainObject) throws Exception {
        Connection connection = ConnectionFactory.getInstance().getConnection();
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT *")
                .append(" FROM ")
                .append(domainObject.getTableName());

        if (domainObject.vratiBrojVezanihObjekata() > 0) {
            sb.append(domainObject.vratiJoinUslov());
            sb.append(domainObject.vratiWhereUslov());
            sb.append(domainObject.getKeyValue());
        } else {
            sb.append(" WHERE ")
                    .append(domainObject.getKeyName())
                    .append(" = ")
                    .append(domainObject.getKeyValue());
        }

        String query = sb.toString();
        System.out.println(query);

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);

        IDomainObject object = domainObject.napraviZaJednog(rs);

        if (domainObject.vratiBrojVezanihObjekata() > 0) {
            StringBuilder sb1 = new StringBuilder();
            System.out.println("1");
            for (int j = 0; j < domainObject.vratiBrojVezanihObjekata(); j++) {
                System.out.println("2");
                IDomainObject vezo = domainObject.vratiVezaniObjekat(j);
                vezo.setId(Long.parseLong(domainObject.getKeyValue()));
                if (vezo != null) {
                    System.out.println("3");
                    sb1.append("SELECT * FROM ")
                            .append(vezo.getTableName())
                            .append(vezo.vratiJoinUslov())
                            .append(" WHERE ")
                            .append(vezo.getKeyName())
                            .append(" = ")
                            .append(vezo.getKeyValue());
                    String query1 = sb1.toString();
                    System.out.println("4");
                    System.out.println(query1);
                    ResultSet rs1 = statement.executeQuery(query1);
                    List<IDomainObject> listica = vezo.napraviListu(rs1);
                    object.setListuVezanih(listica, j);
                    System.out.println("5");
                    sb1.setLength(0);
                }
            }
        }
        if(object == null){
            throw new Exception("No such user");
        }
        return object;
    }

    public List<IDomainObject> getByCrit(IDomainObject domainObject) throws Exception {
        Connection connection = ConnectionFactory.getInstance().getConnection();
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT *")
                .append(" FROM ")
                .append(domainObject.getTableName());

        if (domainObject.vratiBrojVezanihObjekata() > 0) {
            sb.append(domainObject.vratiJoinUslov());
            sb.append(domainObject.vratiKriterijum());
        } else {
            sb.append(" WHERE ")
                    .append(domainObject.vratiKriterijum());
        }

        String query = sb.toString();
        System.out.println(query);

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);

        List<IDomainObject> objects = domainObject.napraviListu(rs);

        return objects;

    }

}