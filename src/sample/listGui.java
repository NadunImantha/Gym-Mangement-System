package sample;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class listGui extends Application {

    @Override
    public void start(Stage stage) {
        //Create a table
        TableView<Member> table = new TableView<Member>();
        table.setLayoutX(38);  table.setLayoutY(100);

        //Set columns in table
        TableColumn col = new TableColumn("Membership no");
        col.setMinWidth(110);
        col.setCellValueFactory(new PropertyValueFactory<Member, String>("extra"));

        TableColumn col_membershipStartDate = new TableColumn("Membership Date");
        col_membershipStartDate.setMinWidth(120);
        col_membershipStartDate.setCellValueFactory(new PropertyValueFactory<Member, String>("membershipStartDate"));

        TableColumn col_memberFirstName = new TableColumn("First Name");
        col_memberFirstName.setMinWidth(110);
        col_memberFirstName.setCellValueFactory(new PropertyValueFactory<Member, String>("memberFirstName"));

        TableColumn col_memberLastName = new TableColumn("Last Name");
        col_memberLastName.setMinWidth(110);
        col_memberLastName.setCellValueFactory(new PropertyValueFactory<Member, String>("memberLastName"));

        TableColumn col_memberType = new TableColumn("Member Type");
        col_memberType.setMinWidth(140);
        col_memberType.setCellValueFactory(new PropertyValueFactory<Member, String>("memberType"));


        //Read records from arrays
        ObservableList<Member> details = FXCollections.observableArrayList();
        for (int i=0; i < FileHandling.toDeleteMembershipNo.size(); i++){
            String raw_membershipStartDate = (String) FileHandling.toDeleteMembershipStartDate.get(i);
            String raw_memberFirstName = (String) FileHandling.toDeleteMemberFirstName.get(i);
            String raw_memberLastName = (String) FileHandling.toDeleteMemberLastName.get(i);
            String raw_membershipType = (String) FileHandling.toDeleteMembershipType.get(i);
            String raw = (String) FileHandling.toDeleteMembershipNo.get(i);
            //Add them
            details.addAll(new Member(raw_membershipStartDate, raw_memberFirstName, raw_memberLastName, raw_membershipType, raw));
        }

        FilteredList<Member> flMembers = new FilteredList(details);//Pass the members details to a filtered list
        table.setItems(flMembers);
        table.getColumns().addAll(col, col_membershipStartDate, col_memberFirstName, col_memberLastName, col_memberType);

        //Title
        Label title = new Label("MEMBERS  DETAILS");
        title.setFont(new Font("Arial", 28));
        title.setLayoutX(21);  title.setLayoutY(33);

        //Adding ChoiceBox
        ChoiceBox<String> choiceToSearch = new ChoiceBox();
        choiceToSearch.setLayoutX(340);   choiceToSearch.setLayoutY(36);
        choiceToSearch.getItems().addAll("Membership No", "First Name", "Last Name", "Member Type");
        choiceToSearch.setValue("Membership No");

        //Adding Textfield
        TextField search = new TextField();
        search.setPromptText("Search here");
        search.setLayoutX(474);  search.setLayoutY(36);
        search.setOnKeyReleased(keyEvent -> {

            switch (choiceToSearch.getValue())//Switch on choiceBox value
            {
                case "Membership No":
                    flMembers.setPredicate(p -> p.getExtra().toLowerCase().contains(search.getText().toLowerCase().trim()));
                    break;
                case "First Name":
                    flMembers.setPredicate(p -> p.getMemberFirstName().toLowerCase().contains(search.getText().toLowerCase().trim()));
                    break;
                case "Last Name":
                    flMembers.setPredicate(p -> p.getMemberLastName().toLowerCase().contains(search.getText().toLowerCase().trim()));
                    break;
                case "Member Type":
                    flMembers.setPredicate(p -> p.getMemberType().toLowerCase().contains(search.getText().toLowerCase().trim()));
                    break;
            }
        });

        //Reset the table when the select another element form choose box
        choiceToSearch.getSelectionModel().selectedItemProperty().addListener(newVal -> {
            if (newVal != null) {
                search.setText("");
                flMembers.setPredicate(null);
            }
        });

        Pane gui = new Pane();
        gui.getChildren().addAll(table,choiceToSearch,search,title);

        Scene scene = new Scene(gui,658,550);
        stage.setTitle("Members Details List");

        stage.setScene(scene);
        stage.show();
    }

    public static class Member {
        private final SimpleStringProperty membershipStartDate;
        private final SimpleStringProperty memberFirstName;
        private final SimpleStringProperty memberLastName;
        private final SimpleStringProperty memberType;
        private final SimpleStringProperty extra;

        public Member(String memDate, String memFName, String memLName, String memType, String ex) {
            this.membershipStartDate = new SimpleStringProperty(memDate);
            this.memberFirstName = new SimpleStringProperty(memFName);
            this.memberLastName = new SimpleStringProperty(memLName);
            this.memberType = new SimpleStringProperty(memType);
            this.extra = new SimpleStringProperty(ex);
        }

        public String getMembershipStartDate()
        {
            return membershipStartDate.get();
        }
        public String getMemberFirstName()
        {
            return memberFirstName.get();
        }
        public String getMemberLastName() { return memberLastName.get(); }
        public String getMemberType()
        {
            return memberType.get();
        }
        public String getExtra()
        {
            return extra.get();
        }

    }

    public static void main(String[] args) { launch(args); }
}