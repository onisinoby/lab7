import javax.swing.*;
//Для создания графического интерфейса приложения
// необходимо использовать специальные компоненты библиотеки Swing,
// называемые контейнерами высшего уровня (top level containers).
// Они представляют собой окна операционной системы, в которых размещаются компоненты пользовательского интерфейса.

import java.awt.*;
//это инструментарий классов в Java, который помогает программисту разрабатывать
// компоненты графического и графического интерфейса пользователя
import java.awt.event.*;
//Пакет java.awt.event
//Предоставляет интерфейсы и классы для обработки различных типов событий, запускаемых компонентами AWT.

public class Football extends JFrame{
    //Ключевое слово extends означает, что на основе существующего класса создается новый класс. Существующий класс
    // называется суперклассом, базовым или родительским, а вновь создаваемый — подклассом, производным или порожденным.
    private static JButton btn_AC_Milan;
    //JButton (Струна текст, Значок значок)
    // Создает кнопку с начальным текстом и значком. Краткое описание метода. защищенная пустота.
    private static JButton btn_Real_Madrid;
    private static JLabel label_result;
    //С помощью JLabel можно показать текст с иконкой.
    // Если нужен какой-то компонент, чтобы отобразить какое-то сообщение
    // пользователю или сделать для поля ввода текстовую метку,
    // или показать иконку — используем JLabel. Текст, который показывает JLabel выделять нельзя, только смотреть.
    //Для создания объекта JLabel, который затем будем располагать в окне, можно воспользоваться конструктором со
    // строковым параметром public JLabel(String text). Строковый параметр — это текст, который будет показываться в JLabel.
    private static JLabel label_scorer;
    private static JLabel label_winner;
    private static int counter_AC_Milan = 0;
    private static int counter_Real_Madrid = 0;

    public static void addComponentsToPane(Container pane) {//панель контейнера

        pane.setLayout(new GridBagLayout());// GridBagLayout компоненты мест в сетке строк и столбцов,
        // позволяя определенные компоненты охватить многократные строки или столбцы.
        GridBagConstraints gbc = new GridBagConstraints();
//открытый класс GridBagConstraints расширяет объект, реализует возможность клонирования, сериализации
//GridBagConstraintsКласс определяет ограничения для компонентов, которые размещаются с использованием
// GridBagLayoutкласса.
        label_winner = new JLabel("Winner: DRAW");
        //JLabel позволяет настраивать шрифт, который будет использоваться для отображения текста.
        // Установка шрифта происходит при помощи метода setFont класса JLabel. Этому методу в качестве параметра
        // передается объект Font. Что мы хотим, когда указываем или создаем шрифт? Первое — это начертание,
        // Verdana или Courier New, или другое. Второе — размер шрифта и третье — жирный будет шрифт или нормальный,
        // или может быть курсив. Поэтому подходящий конструктор для Font это тот, который содержит сразу все три
        // параметра — public Font(String name, int style, int size).
        label_winner.setFont(new Font("Tahoma", Font.PLAIN, 40));
        label_winner.setHorizontalAlignment(label_winner.CENTER);
        //Для того, чтобы установить выравнивание содержимого JLabel вдоль оси X справа в Java,
        // используют метод setHorizontalAlignment()
        gbc.fill = GridBagConstraints.HORIZONTAL;
        // GridBagConstraint.HORIZONTAL Увеличивает ширину компонента,
        // чтобы заставить его заполнить область дисплея горизонтально.
        //Член fill класса GridBagConstraints, используется, чтобы определить, что компонент может
        // расширяться обоими способами, горизонтально или вертикатольно.
        // fill - Определяет, как компонент заполняет ячейку, если ячейка является большей, чем компонент.
        // Значение по умолчанию - отпуск размера неизменного компонента. Рассмотрите следующий
        // список статических членов данных, которые являются значениями для заполняющейся переменной.
        //Чтобы использовать это размещение, информация должна быть обеспечена размером и размещением каждого компонента.
        // Класс'GridBagConstraints' считает всю информацию, требуемую классом GridBagLayout устанавливать и устанавливать
        // размеры каждого компонента. О классе GridBagContraints можно думать как о вспомогательном классе GridBagLayout.
        gbc.weightx = 1;
        //Ограничения для каждого компонента могут быть установлены с помощью метода 'setConstraints ()'. Например:
        //gblay. setConstraints(lbl, gbc);
        //где 'gblay' - объект класса GridBagLayout, lbl - компонент 'Метки', и 'gbc' - объект GridBagConstraints.
        gbc.weighty = 1;
        gbc.gridwidth = 3;
        //Определить число столбцов и компонентов строк, которые должны быть заняты
        //gbc.gridwidth=ncol;
        //gbc.gridheight=nrow;
        //Где:
        //gridwidth - определяет число занятых компонентов столбцов
        //gridheight - определяет число занятых компонентов сток
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        //Размещение компонентов в специфической строке и столбце,
        //gbc.gridx=col ;
        //gbc.gridy=row;
        //Где:
        //gridx - столбец, куда компонент должен быть помещен
        //gridy- строка, куда компонент должен быть помещен
        pane.add(label_winner, gbc);


        btn_AC_Milan = new JButton("  AC Milan  ");
        btn_AC_Milan.setFont(new Font("Tahoma", Font.PLAIN, 80));
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        gbc.gridx = 0;
        gbc.gridy = 1;
        pane.add(btn_AC_Milan, gbc);

        btn_AC_Milan.setActionCommand("Last Scorer: AC Milan");
        //Команда действия идентифицирует кнопку.
        // Таким образом, при использовании двух или более кнопок в одном приложении команда action
        // дает вам простой способ определить, какая кнопка была нажата.


        label_result = new JLabel("Result: 0 X 0");
        label_result.setFont(new Font("Tahoma", Font.PLAIN, 40));
        label_result.setHorizontalAlignment(label_result.CENTER);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.gridx = 1;
        gbc.gridy = 1;
        pane.add(label_result, gbc);


        label_scorer = new JLabel("Last Scorer: N/A");
        label_scorer.setFont(new Font("Tahoma", Font.PLAIN, 40));
        label_scorer.setHorizontalAlignment(label_scorer.CENTER);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.gridx = 1;
        gbc.gridy = 2;
        pane.add(label_scorer, gbc);


        btn_Real_Madrid = new JButton("Real Madrid");
        btn_Real_Madrid.setFont(new Font("Tahoma", Font.PLAIN, 80));
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        gbc.gridx = 2;
        gbc.gridy = 1;
        pane.add(btn_Real_Madrid, gbc);

        btn_Real_Madrid.setActionCommand("Last Scorer: Real Madrid");


        ActionListener actionListener = new TestActionListener();
        //создаем экземпляр нашего слушателя TestActionListener,
        // а затем добавляем его в качестве слушателя к кнопке с помощью вызова
        //addActionListener и передаем ему экземпляр обработчика. Вообще слушателей может быть неопределенное количество.
        // Если нам будет необходимо два или более слушателей, которые должны будут по-разному реагировать на нажатие кнопки,
        // то для каждого из них вызовем addActionListener.
        btn_AC_Milan.addActionListener(actionListener);
        btn_Real_Madrid.addActionListener(actionListener);
    }

    private static void ShowGUI() {
        //  ShowGUI () вызывается функцией startup (), которая не является статической.
        //покажет редактируемый ГИП, например:
        // time(<&результат>, [формат]) — выдаст текущее время и дату, можно указать формат; DATE, TIME, DATETIME.
        JFrame frame = new JFrame();
        // Frame- это окно верхнего уровня с заголовком и рамкой.
        //Для создания окна приложения в Swing используется класс JFrame. Он содержит ряд методов и свойств,
        // которые позволяют настроить его должным образом.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//Сейчас нам необходимо, чтобы при закрытии окна закрывалось и приложение.
        // Для этого мы передаем параметр JFrame.EXIT_ON_CLOSE.
        addComponentsToPane(frame.getContentPane());

        frame.pack();
        //У объекта JFrame есть специальная панель content pane,
        // на которой должны размещаться все остальные дочерние компоненты.
        // С помощью вызова getContentPane мы получаем эту панель и добавляем лейбл уже на нее.
        // Далее устанавливаем размер окна и показываем его пользователю.
        //Размер рамки включает в себя любую область, обозначенную для границы. Размеры пограничной
        // области могут быть получены с использованием getInsetsметода, однако, поскольку эти размеры
        // зависят от платформы, допустимое значение вставок не может быть получено до тех пор, пока фрейм
        // не станет отображаемым с помощью вызова pack или show.
        frame.setSize(1920, 1080);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static class TestActionListener implements ActionListener { //implements это ключевое слово,
        // предназначенное для реализации интерфейса
        public void actionPerformed(ActionEvent e) {
            //Событие action возникает всякий раз, когда пользователь выполняет действие.
            // Примеры: Когда пользователь нажимает кнопку, выбирает пункт меню, нажимает Ввод в текстовом поле.
            // В результате actionPerformed сообщение отправляется всем прослушивателям действий, которые зарегистрированы
            // в соответствующем компоненте
            label_scorer.setText(e.getActionCommand());
            if (e.getSource() == btn_AC_Milan)
            {
                label_result.setText("Result: " + ++counter_AC_Milan + " X " + counter_Real_Madrid);
            }
            else if (e.getSource() == btn_Real_Madrid)
            {
                label_result.setText("Result: " + counter_AC_Milan + " X " + ++counter_Real_Madrid);
            }
            if (counter_AC_Milan > counter_Real_Madrid)
            {
                label_winner.setText("Winner: AC Milan");
            }
            else if (counter_AC_Milan < counter_Real_Madrid)
            {
                label_winner.setText("Winner: Real Madrid");
            }
            else
            {
                label_winner.setText("Winner: DRAW");
            }
        }

    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //открытый класс SwingUtilities расширяет объект, реализует SwingConstants
                //Runnable это интерфейс в Java, представляющий тип, который определяет runметод.
                // Любой класс, который реализует этот интерфейс, должен предоставлять реализацию для run.
                // Runnables представляют задачи, которые должны выполняться другими частями вашей системы.
                //invokeLater - Вызывает асинхронное выполнение doRun.run() в потоке отправки событий AWT.
                // Это произойдет после обработки всех ожидающих событий AWT.
                // Этот метод следует использовать, когда потоку приложения необходимо обновить графический интерфейс.
                ShowGUI();
            }
        });
    }
}