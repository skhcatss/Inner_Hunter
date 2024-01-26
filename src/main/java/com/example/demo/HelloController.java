package com.example.demo;

import com.fasterxml.jackson.databind.JsonNode;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;


import java.io.*;
import java.net.URL;
import java.util.Base64;
import java.util.Map;
import java.util.ResourceBundle;

public class HelloController implements Initializable {


    public TableColumn<Object, Object> ip;
    public TableColumn<Object, Object> port;
    public TableColumn<Object, Object> web_title;
    public TableColumn<Object, Object> domain;
    public TableColumn<Object, Object> is_risk_protocol;
    public TableColumn<Object, Object> component;
    public TableColumn<Object, Object> os;
    public TableColumn<Object, Object> company;

    public TableColumn<Object, Object> number;
    public TableColumn<Object, Object> country;

    public TableColumn<Object, Object> url_res;
    public DatePicker starttime;
    public DatePicker endtime;
    public TextField page;
    public TextArea textAres;

    public Text consume_quota;
    public Text rest_quota;
    public Button searchbtn;
    @FXML
    private PasswordField apikey;
    @FXML
    private Button clearcontent;
    @FXML
    private Button clearlog;

    @FXML
    private ChoiceBox<String> model;
    private String[] model_choice = {"外部鹰图","内部鹰图"};

    @FXML
    private Button outfilebtn;

    @FXML
    private ChoiceBox<String> page_size;
    private final String[] page_size_choice = {"10", "20", "50", "100"};

    @FXML
    private TextField search;

    @FXML
    private TableView<TableData> table;

    @FXML
    private ChoiceBox<String> type;
    private final String[] type_choice = {"web资产", "非web资产", "全部"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //设置下拉列表的值
        model.getItems().addAll(model_choice);
        model.getSelectionModel().select(0);


        page_size.getItems().addAll(page_size_choice);
        page_size.getSelectionModel().select(0);

        type.getItems().addAll(type_choice);
        type.getSelectionModel().select(0);


        ip.setCellValueFactory(new PropertyValueFactory<>("ip"));
        url_res.setCellValueFactory(new PropertyValueFactory<>("url_res"));
        port.setCellValueFactory(new PropertyValueFactory<>("port"));
        web_title.setCellValueFactory(new PropertyValueFactory<>("web_title"));
        domain.setCellValueFactory(new PropertyValueFactory<>("domain"));
        is_risk_protocol.setCellValueFactory(new PropertyValueFactory<>("is_risk_protocol"));
        component.setCellValueFactory(new PropertyValueFactory<>("component"));
        os.setCellValueFactory(new PropertyValueFactory<>("os"));
        company.setCellValueFactory(new PropertyValueFactory<>("company"));
        number.setCellValueFactory(new PropertyValueFactory<>("number"));
        country.setCellValueFactory(new PropertyValueFactory<>("country"));

    }

    //临时存储json
    TempJson tmp_json = new TempJson();


    //查询按钮事件
    public void ToSearch(MouseEvent mouseEvent) throws IOException {



        String currentDir = System.getProperty("user.dir");
        String dir = currentDir +"/hunter.ini";
        File file = new File(dir);

        if (!file.exists()){
            textAres.setStyle("-fx-text-fill: red;");
            textAres.appendText("Warnning:hunter.ini 文件不存在\n");
            textAres.appendText("-----------------------------------\n");

        }else{
                BufferedReader reader = new BufferedReader(new FileReader(dir));
                String line = reader.readLine();
                apikey.setText(line);
        }



//------输入参数简单校验---------------------------

        if (apikey.getText().trim().isEmpty()) {
            textAres.setStyle("-fx-text-fill: red;");
            textAres.appendText("Warnning:API-KEY信息为空\n");
        }

        if (search.getText().trim().isEmpty()) {
            textAres.setStyle("-fx-text-fill: red;");
            textAres.appendText("Warnning:检索语法为空\n");
        }
        if (!page.getText().matches("\\d+")) {
            textAres.setStyle("-fx-text-fill: red;");
            textAres.appendText("Warnning:页码内容不正确\n");
        }

        if (starttime.getValue() == null) {
            textAres.setStyle("-fx-text-fill: red;");
            textAres.appendText("Warnning:开始时间为空\n");

        }
        if (endtime.getValue() == null) {
            textAres.setStyle("-fx-text-fill: red;");
            textAres.appendText("Warnning:结束时间为空\n");
        }
        textAres.appendText("-----------------------------------\n");


    //---------------查询----------------


        UserInfo usrInfo = new UserInfo();
        //检索语法  对查询语法进行base64编码
        usrInfo.setEncodedString(Base64.getEncoder().encodeToString(search.getText().getBytes()));
        //请求条数
        usrInfo.setPage(Integer.parseInt(page.getText()));
        //鹰图模式
        usrInfo.setModel(model.getSelectionModel().getSelectedItem());
        //资产类型
        usrInfo.setIs_web(type.getSelectionModel().getSelectedItem());
        //APIKEY
        usrInfo.setApikey(apikey.getText());
        //页码
        usrInfo.setPage_size(Integer.parseInt(page_size.getSelectionModel().getSelectedItem()));
        //开始时间
        usrInfo.setStart_time(starttime.getValue().toString());
        //结束时间
        usrInfo.setEnd_time(endtime.getValue().toString());

        //请求数据
        String jsonString = RequestApiData.RequestHunter(usrInfo);

        if (jsonString.equals("Error:UnknownHostException")) {
            textAres.setStyle("-fx-text-fill: red;");
            textAres.appendText("Error:UnknownHostException\n");
            textAres.appendText("-----------------------------------\n");

        } else {


            tmp_json.setJson_str(jsonString);
            ObservableList<TableData> list = FXCollections.observableArrayList();
            Map res = JsonDataHandle.datahandle(jsonString);


            if (!res.get("code").equals("200")) {
                textAres.setStyle("-fx-text-fill: red;");
                textAres.appendText("状态码" + res.get("code") + "\n信息" + res.get("message") + "\n");
                textAres.appendText("-----------------------------------\n");
            }


            JsonNode arrNode = (JsonNode) res.get("arrNode");
            for (JsonNode itemNode : arrNode) {

                //1-IP
                String ip = itemNode.get("ip").asText();
                //2-端口
                String port = itemNode.get("port").asText();
                //3-域名
                String domain = itemNode.get("domain").asText();
                //4-IP标签  null
                //5-url
                String url_res = itemNode.get("url").asText();
                //6-网站标题
                String web_title = itemNode.get("web_title").asText();
                //7-高危协议
                String is_risk_protocol = itemNode.get("is_risk_protocol").asText();
                //11-应用/组件
                String component = itemNode.get("component").asText();
                //12-操作系统
                String os = itemNode.get("os").asText();
                //13-备案单位
                String company = itemNode.get("company").asText();
                //14-备案号
                String number = itemNode.get("number").asText();
                //15-国家
                String country = itemNode.get("country").asText();

                list.add(new TableData(ip, url_res, port, web_title, domain, is_risk_protocol, component, os, company, number, country));

            }


            //System.out.println(list);
            table.setItems(list);
            textAres.setStyle("-fx-text-fill: green;");
            textAres.appendText("状态码" + res.get("code") + "  信息" + res.get("message") + "\n");

            consume_quota.setText((String) res.get("consume_quota"));
            rest_quota.setText((String) res.get("rest_quota"));

        }


    }

    public void ToCleanLog(MouseEvent mouseEvent) {
        textAres.setText("");
    }


    public void ToCleanTable(MouseEvent mouseEvent) {
        ObservableList<TableData> list_clear = FXCollections.observableArrayList();
        list_clear.add(new TableData("", "", "", "", "", "", "", "", "", "", ""));
        table.setItems(list_clear);
    }


    //导出excel
    public void ToCsv(MouseEvent mouseEvent) {
        if (tmp_json.getJson_str() == null) {
            textAres.setStyle("-fx-text-fill: red;");
            textAres.appendText("Warnning:请先进行查询再进行导出操作\n");
            textAres.appendText("-----------------------------------\n");

        } else {
            System.out.println(tmp_json.getJson_str());
            String outRes = TableDataToExcel.toExcel(tmp_json.getJson_str());
            textAres.appendText("-----------------------------------\n");
            textAres.appendText(outRes + "\n");


        }


    }
}
