theme: /

    state: newNode_28
        a:  Привет {{$session.rawRequest.message.from.first_name}}!
            Твой iD {{$session.rawRequest.message.from.id}}
            Заходи в гости. || html = "Привет {{$session.rawRequest.message.from.first_name}}!<br>Твой iD&nbsp;{{$session.rawRequest.message.from.id}}<br>Заходи в гости.", htmlEnabled = true
        go!: /newNode_29
    @IntentGroup
        {
          "boundsTo" : "/newNode_28",
          "actions" : [ {
            "buttons" : [ {
              "name" : "@Well_DrillingBot",
              "transition" : "",
              "url" : "https://t.me/Well_DrillingBot"
            } ],
            "type" : "buttons"
          } ],
          "global" : true
        }
    state: newNode_29
        state: 1
            intent!: /newNode_29/1

            go!: /newNode_31

        state: 2
            intent!: /newNode_29/2

            go!: /newNode_148

        state: 3
            intent!: /newNode_29/3

            go!: /newNode_33

        state: 4
            intent!: /newNode_29/4

            go!: /newNode_35

        state: 5
            intent!: /newNode_29/5

            go!: /newNode_40

        state: 6
            intent!: /newNode_29/6

            go!: /newNode_39

        state: 7
            intent!: /newNode_29/7

            go!: /newNode_43

        state: 8
            intent!: /newNode_29/8

            go!: /newNode_45

        state: 9
            intent!: /newNode_29/9

            go!: /newNode_47

        state: 10
            intent!: /newNode_29/10

            go!: /newNode_49

        state: 11
            intent!: /newNode_29/11

            go!: /newNode_51

        state: 12
            intent!: /newNode_29/12

            go!: /newNode_53

        state: 13
            intent!: /newNode_29/13

            go!: /newNode_55

        state: 14
            intent!: /newNode_29/14

            go!: /newNode_55

        state: 15
            intent!: /newNode_29/15

            go!: /newNode_57

        state: 16
            intent!: /newNode_29/16

            go!: /newNode_55

        state: 17
            intent!: /newNode_29/17

            go!: /newNode_56

        state: 18
            intent!: /newNode_29/18

            go!: /newNode_57

        state: 19
            intent!: /newNode_29/19

            go!: /newNode_61

        state: 20
            intent!: /newNode_29/20

            go!: /newNode_63

        state: 21
            intent!: /newNode_29/21

            go!: /newNode_27

        state: 22
            intent!: /sys/aimylogic/ru/insults

            go!: /newNode_55

        state: 23
            intent!: /newNode_29/23

            go!: /newNode_148

        state: 24
            intent!: /newNode_29/24

            go!: /newNode_65

        state: 25
            intent!: /newNode_29/25

            go!: /newNode_67

        state: 26
            intent!: /newNode_29/26

            go!: /newNode_69

        state: 27
            intent!: /newNode_29/27

            go!: /newNode_72

        state: 28
            intent!: /newNode_29/28

            go!: /newNode_174

        state: 29
            intent!: /newNode_29/29

            go!: /newNode_81

        state: 30
            intent!: /newNode_29/30

            go!: /newNode_81

        state: 31
            intent!: /newNode_29/31

            go!: /newNode_78

        state: 32
            intent!: /newNode_29/32

            go!: /newNode_82

        state: 33
            intent!: /newNode_29/33

            go!: /newNode_85

        state: 34
            intent!: /newNode_29/34

            go!: /newNode_89

        state: 35
            intent!: /newNode_29/35

            go!: /newNode_10

        state: 36
            intent!: /newNode_29/36

            go!: /newNode_94

        state: 37
            intent!: /newNode_29/37

            go!: /newNode_132

        state: 38
            intent!: /newNode_29/38

            go!: /newNode_135

        state: 39
            intent!: /newNode_29/39

            go!: /newNode_139

        state: 40
            intent!: /newNode_29/40

            go!: /newNode_153

        state: 41
            intent!: /newNode_29/41

            go!: /

        state: Fallback
            event: noMatch
            go!: /newNode_25
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_29",
                name: "newNode_29 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "@Well_DrillingBot"
                    , url: "https://t.me/Well_DrillingBot"
                    },
                  ]);
                }
            });

    state: newNode_0
        a:  {{$session.rawRequest.message.from.first_name}}
            Ответьте на вопросы, чтобы понять возможность организации абиссинской скважины в Вашей локации.
            Продолжим?
        script:
            $reactions.timeout({interval: _.template('30 seconds', {variable: '$session'})($session), targetState: '/newNode_101'});
        go!: /newNode_98
    @IntentGroup
        {
          "boundsTo" : "/newNode_0",
          "actions" : [ {
            "buttons" : [ {
              "name" : "Да",
              "transition" : "/newNode_12"
            }, {
              "name" : "Нет",
              "transition" : "/newNode_101"
            } ],
            "type" : "buttons"
          } ],
          "global" : false
        }
    state: newNode_98
        state: 1
            intent: /sys/aimylogic/ru/agreement

            go!: /newNode_12

        state: 2
            intent: /sys/aimylogic/ru/negation

            go!: /newNode_51

        state: Fallback
            event: noMatch
            go!: /newNode_51
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_98",
                name: "newNode_98 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Да"
                    , transition: "/newNode_12"
                    },
                    {text: "Нет"
                    , transition: "/newNode_101"
                    },
                  ]);
                }
            });

    state: newNode_12
        script:
            $reactions.timeout({interval: _.template('1 minutes', {variable: '$session'})($session), targetState: '/newNode_101'});
        go!: /newNode_13

    state: newNode_13
        InputText:
            actions = [{"buttons":[],"type":"buttons"}]
            prompt = В каком населённом пункте нужна абиссинская скважина?
            varName = text
            html = В каком населённом пункте нужна абиссинская скважина?
            htmlEnabled = false
            then = /newNode_14
    @IntentGroup
        {
          "boundsTo" : "",
          "actions" : [ {
            "buttons" : [ ],
            "type" : "buttons"
          } ],
          "global" : false
        }
    state: newNode_11
        state: 1
            intent: /sys/aimylogic/ru/city

            go!: /newNode_1

        state: Fallback
            event: noMatch
            go!: /newNode_7
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_11",
                name: "newNode_11 buttons",
                handler: function($context) {
                }
            });

    state: newNode_1
        GoogleSheets:
            operationType = writeDataToLine
            integrationId = 6bd68579-b158-48fa-97f0-1b609be2c039
            spreadsheetId = 115QNHWbqdN2d291bQuXx6oJ-iEJfOLuyYAQpZOIzJXU
            sheetName = Лист1
            body = {"values":["{{$session.rawRequest.message.from.username}}","{{$session.rawRequest.message.from.first_name}}","{{$session.rawRequest.message.from.id}}","{{$session.CITY}}","{{$session.text}}"]}
            okState = /newNode_14
            errorState = /newNode_7

    state: newNode_14
        a: У Вас или у ваших соседей уже есть абиссинская скважина?
        script:
            $reactions.timeout({interval: _.template('30 seconds', {variable: '$session'})($session), targetState: '/newNode_101'});
        go!: /newNode_16
    @IntentGroup
        {
          "boundsTo" : "/newNode_14",
          "actions" : [ {
            "buttons" : [ {
              "name" : "Да",
              "transition" : "/newNode_109"
            }, {
              "name" : "Нет",
              "transition" : "/newNode_15"
            } ],
            "type" : "buttons"
          } ],
          "global" : false
        }
    state: newNode_16
        state: 1
            intent: /sys/aimylogic/ru/agreement

            go!: /newNode_109

        state: 2
            intent: /sys/aimylogic/ru/negation

            go!: /newNode_15

        state: Fallback
            event: noMatch
            go!: /newNode_101
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_16",
                name: "newNode_16 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Да"
                    , transition: "/newNode_109"
                    },
                    {text: "Нет"
                    , transition: "/newNode_15"
                    },
                  ]);
                }
            });

    state: newNode_15
        a: Возможно поблизости есть колодец?
        script:
            $reactions.timeout({interval: _.template('30 seconds', {variable: '$session'})($session), targetState: '/newNode_101'});
        go!: /newNode_17
    @IntentGroup
        {
          "boundsTo" : "/newNode_15",
          "actions" : [ {
            "buttons" : [ {
              "name" : "Да",
              "transition" : "/newNode_18"
            }, {
              "name" : "Нет",
              "transition" : "/newNode_100"
            } ],
            "type" : "buttons"
          } ],
          "global" : false
        }
    state: newNode_17
        state: 1
            intent: /sys/aimylogic/ru/agreement

            go!: /newNode_18

        state: 2
            intent: /sys/aimylogic/ru/negation

            go!: /newNode_100

        state: Fallback
            event: noMatch
            go!: /newNode_101
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_17",
                name: "newNode_17 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Да"
                    , transition: "/newNode_18"
                    },
                    {text: "Нет"
                    , transition: "/newNode_100"
                    },
                  ]);
                }
            });

    state: newNode_18
        a: Сколько метров или количество колец?
        script:
            $reactions.timeout({interval: _.template('30 seconds', {variable: '$session'})($session), targetState: '/newNode_101'});
        go!: /newNode_19

    state: newNode_19
        InputNumber:
            actions = [{"buttons":[],"type":"buttons"}]
            prompt = Введите число
            varName = number
            failureMessage = ["Введите число от 0 до 20. Если не известно напишите 100"]
            then = /newNode_20
            minValue = 1
            maxValue = 100
            html = Введите число
            htmlEnabled = false
            failureMessageHtml = ["Введите число от 0 до 20. Если не известно напишите 100"]

    state: newNode_20
        script:
            $reactions.timeout({interval: _.template('30 seconds', {variable: '$session'})($session), targetState: '/newNode_101'});
        go!: /newNode_21

    state: newNode_21
        InputNumber:
            actions = [{"buttons":[],"type":"buttons"}]
            prompt = Сколько метров или колец от земли до воды?
            varName = number2
            failureMessage = ["Введите число от 0 до 20. Если не известно напишите 100"]
            then = /newNode_126
            minValue = 0
            maxValue = 100
            html = Сколько метров или колец от земли до воды?
            htmlEnabled = false
            failureMessageHtml = ["Введите число от 0 до 20. Если не известно напишите 100"]

    state: newNode_22
        a:  Ваши данные 
            отправлены
            ID {{$session.rawRequest.message.from.id}}
            {{$session.time}} Москва || html = "Ваши данные&nbsp;<br>отправлены<br>ID {{$session.rawRequest.message.from.id}}<br>{{$session.time}} Москва", htmlEnabled = true
        # Transition /newNode_24
        go!: /newNode_91

    state: newNode_23
        GoogleSheets:
            operationType = writeDataToLine
            integrationId = 6bd68579-b158-48fa-97f0-1b609be2c039
            spreadsheetId = 115QNHWbqdN2d291bQuXx6oJ-iEJfOLuyYAQpZOIzJXU
            sheetName = Лист1
            body = {"values":["{{$session.number}}","{{$session.number2}}","{{$session.text}}","{{$session.text2}}","{{$session.text3}}","{{$session.PHONE}}","{{$session.numberDrill}}","{{$session.rawRequest.message.from.id}}","{{$session.userFile}}","{{$session.textGeo}}","{{$session.mesageApp}}","{{$session.time}}"]}
            okState = /newNode_22
            errorState = /newNode_7

    state: newNode_99
        script:
            $reactions.timeout({interval: _.template('1 minutes', {variable: '$session'})($session), targetState: '/newNode_104'});
        go!: /newNode_96

    state: newNode_96
        InputText:
            actions = [{"buttons":[{"name":"Фото","transition":"/newNode_112"},{"name":"Нет","transition":"/newNode_120"}],"type":"buttons"}]
            prompt = Что то ещё можете добавить? Например фото вашего источника воды(Колодец, Родник, Водоём)
            varName = text3
            html = Что то ещё можете добавить? Например фото вашего источника воды(Колодец, Родник, Водоём)
            htmlEnabled = false
            then = /newNode_120

    state: newNode_104
        a: Укажите номер телефона.
        # Transition /newNode_105
        go!: /newNode_108

    state: newNode_108
        script:
            $reactions.timeout({interval: _.template('1 minutes', {variable: '$session'})($session), targetState: '/newNode_101'});
        go!: /newNode_103
    @IntentGroup
        {
          "boundsTo" : "/newNode_108",
          "actions" : [ {
            "buttons" : [ {
              "name" : "Другой вид связи",
              "transition" : "/newNode_123"
            }, {
              "name" : "Нет",
              "transition" : "/newNode_101"
            } ],
            "type" : "buttons"
          } ],
          "global" : false
        }
    state: newNode_103
        state: 1
            intent: /sys/aimylogic/ru/phone

            go!: /newNode_123

        state: Fallback
            event: noMatch
            go!: /newNode_124
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_103",
                name: "newNode_103 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Другой вид связи"
                    , transition: "/newNode_123"
                    },
                    {text: "Нет"
                    , transition: "/newNode_101"
                    },
                  ]);
                }
            });

    state: newNode_124
        a: Вы ошиблись или ввели не корректный номер.
        # Transition /newNode_125
        go!: /newNode_104

    state: newNode_123
        script:
            $reactions.timeout({interval: _.template('30 seconds', {variable: '$session'})($session), targetState: '/newNode_101'});
        go!: /newNode_122

    state: newNode_122
        InputText:
            actions = [{"buttons":[],"type":"buttons"}]
            prompt = Укажите предпочтительный вид связи. (Звонок. Мессенджер. СМС)
            varName = mesageApp
            html = Укажите предпочтительный вид связи. (Звонок. Мессенджер. СМС)
            htmlEnabled = false
            then = /newNode_129

    state: newNode_5
        HttpRequest:
            url = https://fra1.blynk.cloud/external/api/update?token=VPz68tdzzleq7Dhoa8eORXWPVYaa1Ufu&v2=1
            method = GET
            body = 
            okState = /newNode_176
            errorState = /newNode_7
            timeout = 0
            headers = []
            vars = []

    state: newNode_176
        HttpRequest:
            url = https://fra1.blynk.cloud/external/api/update?token=RgmgwsZ4dYgSr8Q_R8a2McrS0bwvW4rg&v2=1
            method = GET
            body = 
            okState = /newNode_25
            errorState = /newNode_7
            timeout = 0
            headers = []
            vars = []

    state: newNode_10
        if: $session.rawRequest.message.from.id === 5383352185
            go!: /newNode_0
        elseif: $session.rawRequest.message.from.id === 775897365
            go!: /newNode_0
        elseif: $session.rawRequest.message.from.id === 188329744
            go!: /newNode_0
        else:
            go!: /newNode_149

    state: newNode_27
        a: Не допустимое выражение.
        # Transition /newNode_30
        go!: /newNode_25

    state: newNode_31
        random:
            a: Привет {{$session.rawRequest.message.from.first_name}}
            a: {{$session.rawRequest.message.from.first_name}}
        # Transition /newNode_32
        go!: /newNode_76

    state: newNode_40
        a:  Ручки всегда в наличии у ребят из Раменского
            +79265570934
            2900руб
        # Transition /newNode_41
        go!: /newNode_25

    state: newNode_43
        random:
            a: Пятница - Развратница
            a: Что опять?!
            a: Пятница, так и алкашом стать не долго!
        # Transition /newNode_44
        go!: /newNode_25

    state: newNode_45
        random:
            a:  Бухают три алкаша. Вдруг один из них отключается и падает мордой в грязь. Другой говорит третьему:
                - Вот, за что я люблю Леху, так это за то, что он всегда знает, когда остановиться!
            a: Я не пью!
            a: Совсем не пьёт только тот, у кого руки прибиты.
        # Transition /newNode_46
        go!: /newNode_25

    state: newNode_47
        image: https://248305.selcdn.ru/zfl_prod/1000028281/261256322/ddgP9MeQiuuBxOgi.jpg
        random:
            a:  Поворотную муфту делают
                Степан +79062248126
                @stepanolegovich777
                
                Дмитрий +79018030933
                4000руб
            a:  Поворотную муфту как у Сенсея на видео, делают
                Степан @stepanolegovich777
                Дмитрий +79018030933
                4000руб
        # Transition /newNode_48
        go!: /newNode_25

    state: newNode_51
        a: Удачи!!!
        # Transition /newNode_52
        go!: /newNode_25

    state: newNode_53
        random:
            a: За-е-бум-ба!
            a: Настоящая Заебумба может быть только утром.
            a: Заебумбище
            a: 👍
        # Transition /newNode_54
        go!: /newNode_5

    state: newNode_63
        a:  Фильтры
            Отдел продаж 
            +79606698682 || html = "<a href=\"https://ntp68.ru/product-category/filters/?v=f9308c5d0596\">Фильтры</a><br>Отдел продаж&nbsp;<br>+79606698682<br>", htmlEnabled = true
        # Transition /newNode_64
        go!: /newNode_25

    state: newNode_65
        a:  Труба ПНД 3мм\n
            Отдел продаж
            +79606698682 || html = "<a href=\"https://ntp68.ru/product/%d1%82%d1%80%d1%83%d0%b1%d0%b0-%d0%bf%d0%bd%d0%b4-32%d1%853%d0%bc%d0%bc/?v=f9308c5d0596\">Труба ПНД 3мм</a><br><br>Отдел продаж<br>+79606698682<br>", htmlEnabled = true
        # Transition /newNode_66
        go!: /newNode_25

    state: newNode_81
        EndSession:

    state: newNode_78
        image: https://248305.selcdn.ru/zfl_prod/1000028281/261256322/FUfWeABmyP8cAjD0.jpg
        a:  Изготовить бур сможет
            Виктор из Кургана
            +79125720844
            2х лопастной - 2800руб
            3х лопастной - 3800руб
        go!: /newNode_84

    state: newNode_84
        EndSession:

    state: newNode_89
        a: Ваш ID {{$session.rawRequest.message.from.id}}
        go!: /newNode_90

    state: newNode_90
        EndSession:

    state: newNode_91
        a:  После обработки информации
            Мастера из {{$session.text}} свяжутся с вами.
            Всего вам доброго.  || html = "После обработки информации<br>Мастера из {{$session.text}} свяжутся с вами.<br>Всего вам доброго.&nbsp;", htmlEnabled = true

    state: newNode_101
        random:
            a:  Видать разговор наш с Вами {{$session.rawRequest.message.from.first_name}} не задался. 
                Пока! || html = "Видать разговор наш с Вами {{$session.rawRequest.message.from.first_name}} не задался.&nbsp;<br>Пока!", htmlEnabled = true
            a:  {{$session.rawRequest.message.from.first_name}}
                Извини, но мне нужно идти помогать другим.
                Доcвидания! || html = "{{$session.rawRequest.message.from.first_name}}<br>Извини, но мне нужно идти помогать другим.<br>Доcвидания!", htmlEnabled = true
        go!: /newNode_102

    state: newNode_102
        EndSession:

    state: newNode_94
        a:  SWELL
            Полимер для борьбы с поглощениями бурового раствора\n
            есть тут || html = "<u><a href=\"https://ntp68.ru/product/swell-%d0%bf%d0%be%d0%bb%d0%b8%d0%bc%d0%b5%d1%80-%d0%b4%d0%bb%d1%8f-%d0%b1%d0%be%d1%80%d1%8c%d0%b1%d1%8b-%d1%81-%d0%bf%d0%be%d0%b3%d0%bb%d0%be%d1%89%d0%b5%d0%bd%d0%b8%d1%8f%d0%bc%d0%b8-%d0%b1%d1%83/?v=f9308c5d0596\"></a></u><u><a href=\"https://ntp68.ru/product/swell-%d0%bf%d0%be%d0%bb%d0%b8%d0%bc%d0%b5%d1%80-%d0%b4%d0%bb%d1%8f-%d0%b1%d0%be%d1%80%d1%8c%d0%b1%d1%8b-%d1%81-%d0%bf%d0%be%d0%b3%d0%bb%d0%be%d1%89%d0%b5%d0%bd%d0%b8%d1%8f%d0%bc%d0%b8-%d0%b1%d1%83/?v=f9308c5d0596\"></a></u>SWELL<br>Полимер для борьбы с поглощениями бурового раствора<br><br><a href=\"https://ntp68.ru/product/swell-%d0%bf%d0%be%d0%bb%d0%b8%d0%bc%d0%b5%d1%80-%d0%b4%d0%bb%d1%8f-%d0%b1%d0%be%d1%80%d1%8c%d0%b1%d1%8b-%d1%81-%d0%bf%d0%be%d0%b3%d0%bb%d0%be%d1%89%d0%b5%d0%bd%d0%b8%d1%8f%d0%bc%d0%b8-%d0%b1%d1%83/?v=f9308c5d0596\">есть тут</a>", htmlEnabled = true
        go!: /newNode_95

    state: newNode_95
        EndSession:

    state: newNode_100
        script:
            $reactions.timeout({interval: _.template('1 minutes', {variable: '$session'})($session), targetState: '/newNode_101'});
        go!: /newNode_97

    state: newNode_97
        InputText:
            actions = [{"buttons":[],"type":"buttons"}]
            prompt = Как Ваши соседи добывают воду?
            varName = text2
            html = Как Ваши соседи добывают воду?
            htmlEnabled = true
            then = /newNode_99

    state: newNode_109
        a: Известен её метраж?
        buttons:
            "Да" -> /newNode_110
            "Нет" -> /newNode_15

    state: newNode_110
        InputNumber:
            actions = [{"buttons":[],"type":"buttons"}]
            prompt = Укажите метраж.
            varName = numberDrill
            failureMessage = ["Введите число от 0 до 50. Если не известно напишите 100"]
            then = /newNode_99
            minValue = 1
            maxValue = 100
            html = Укажите метраж.
            htmlEnabled = false
            failureMessageHtml = ["Введите число от 0 до 50. Если не известно напишите 100"]

    state: newNode_112
        script:
            $reactions.timeout({interval: _.template('60 seconds', {variable: '$session'})($session), targetState: '/newNode_104'});
        go!: /newNode_111

    state: newNode_111
        InputFile:
            prompt = Прикрепите файл
            varName = userFile
            then = /newNode_120
            errorState = /newNode_113
            html = Прикрепите файл
            htmlEnabled = false

    state: newNode_113
        a:  Похоже не удалось загрузить фото.
            Попробуете ещё раз? || html = "Похоже не удалось загрузить фото.<br>Попробуете ещё раз?", htmlEnabled = true
        buttons:
            "Да" -> /newNode_112
            "Нет" -> /newNode_104

    state: newNode_120
        a: Google карта || html = "<a href=\"https://google.com/maps/\">Google карта</a><br>", htmlEnabled = true
        script:
            $reactions.timeout({interval: _.template('2 minutes', {variable: '$session'})($session), targetState: '/newNode_104'});
        go!: /newNode_114

    state: newNode_114
        InputText:
            actions = [{"buttons":[{"name":"Нет","transition":"/newNode_104"}],"type":"buttons"}]
            prompt = Установите метку на карте. Используя кнопку "Поделится" копируя вставьте из буфера.
            varName = textGeo
            html = Установите метку на карте. Используя кнопку "Поделится" копируя вставьте из буфера.
            htmlEnabled = false
            then = /newNode_104

    state: newNode_141
        a: говно
        go!: /newNode_142

    state: newNode_142
        EndSession:

    state: newNode_7
        a: error

    state: newNode_25
        EndSession:

    state: newNode_33
        image: https://248305.selcdn.ru/zfl_prod/1000028281/261256322/mx6ZIhNA6mwcHbrn.jpg
        a: @RollDrilling👍
        go!: /newNode_152

    state: newNode_152
        EndSession:

    state: newNode_35
        image: https://248305.selcdn.ru/zfl_prod/1000028281/261256322/luYMy5QfiGUanhYm.jpg
        a: Водомерка || html = "<a href=\"https://play.google.com/store/apps/details?id=com.malchikdima2011.vodomerka\">Водомерка</a>", htmlEnabled = true
        # Transition /newNode_36
        go!: /newNode_135

    state: newNode_39
        a:  Про насосы всё знает
            @Valery_Omnigena
        # Transition /newNode_42
        go!: /newNode_25

    state: newNode_49
        random:
            a: Первая не последняя ;)
            a: Первая скважина - как первая любовь!
        # Transition /newNode_50
        go!: /newNode_25

    state: newNode_55
        random:
            a: Попрошу без мата
            a: Выбирайте выражения.
            a: Нецензурные выражения запрещены.
        go!: /newNode_60

    state: newNode_60
        EndSession:

    state: newNode_57
        a: ;)
        # Transition /newNode_58
        go!: /newNode_25

    state: newNode_56
        a: Топографическая карта высот || html = "<a href=\"https://ru-ru.topographic-map.com/maps/eth6/%D0%A0%D0%BE%D1%81%D1%81%D0%B8%D1%8F/\">Топографическая карта высот</a>", htmlEnabled = true
        go!: /newNode_59

    state: newNode_59
        EndSession:

    state: newNode_61
        a:  STAB-A стабилизатор бурового раствора. 
            Отдел продаж 
            +79606698682 || html = "<a href=\"https://ntp68.ru/product/stab-стабилизатор-бурового-раствора/?v=f9308c5d0596\">STAB-A стабилизатор бурового раствора.</a>&nbsp;<br>Отдел продаж&nbsp;<br>+79606698682", htmlEnabled = true
        # Transition /newNode_62
        go!: /newNode_25

    state: newNode_72
        a: Про бассейны тут || html = "<u><a href=\"https://t.me/pool_and_borehole\">Про бассейны тут</a></u>", htmlEnabled = true
        go!: /newNode_73

    state: newNode_73
        EndSession:

    state: newNode_74
        a:  Форум
            Объединённые абиссинщики || html = "<a href=\"https://abyssro.ru/\">Форум</a><br>Объединённые абиссинщики<br>", htmlEnabled = true
        go!: /newNode_75

    state: newNode_75
        EndSession:

    state: newNode_85
        random:
            a: Да туточки Я!
            a: Що?
            a:  {{$session.rawRequest.message.from.first_name}}
                НЕ ОРИ МНЕ в УХО.
                Я слепой, а не глухой!!!
        go!: /newNode_86

    state: newNode_86
        EndSession:

    state: newNode_116
        a: Ваши координаты {{$session.geo}}
        # Transition /newNode_117
        go!: /newNode_99

    state: newNode_118
        a: Ошибка в запросе geo
        # Transition /newNode_119
        go!: /newNode_91

    state: newNode_121
        HttpRequest:
            url = http://ip-api.com/json/
            method = GET
            body = 
            okState = /newNode_116
            errorState = /newNode_118
            timeout = 0
            headers = []
            vars = [{"name":"geocity2","value":"$session.httpResponse.city"},{"name":"lat","value":"$session.httpResponse.lat"},{"name":"lon","value":"$session.httpResponse.lon"},{"name":"region","value":"$session.httpResponse.regionName"}]

    state: newNode_126
        if: $session.number < $session.number2;
            go!: /newNode_127
        else:
            go!: /newNode_99

    state: newNode_127
        a:  Кажется вы указали не верные значения
            Общая глубина {{$session.number}} не может быть меньше глубины до поверхности воды {{$session.number2}}
            Повторите и введите верные значения.
        # Transition /newNode_128
        go!: /newNode_18

    state: newNode_129
        HttpRequest:
            url = http://tools.aimylogic.com/api/now?tz=Europe/Moscow
            method = GET
            body = 
            okState = /newNode_23
            errorState = /newNode_23
            timeout = 0
            headers = []
            vars = [{"name":"time","value":"$session.httpResponse.formatted"}]

    state: newNode_130
        a: {{$session.time2}} мск
        go!: /newNode_150

    state: newNode_150
        EndSession:

    state: newNode_132
        HttpRequest:
            url = http://tools.aimylogic.com/api/now?tz=Europe/Moscow
            method = GET
            body = 
            okState = /newNode_130
            errorState = /newNode_133
            timeout = 0
            headers = []
            vars = [{"name":"time2","value":"$session.httpResponse.formatted"}]

    state: newNode_133
        a: Кукушка спит.
        go!: /newNode_134

    state: newNode_134
        EndSession:

    state: newNode_139
        HttpRequest:
            url = https://api.telegram.org/bot5379015773:AAE20C3PdUtLIjgCRICOrK_qtqhWFuPrzXE/request_location
            method = GET
            body = 
            okState = /newNode_140
            errorState = /newNode_140
            timeout = 0
            headers = []
            vars = [{"name":"TRE","value":"$session.httpResponse"}]

    state: newNode_140
        a: {{$session.TRE}} tt
        go!: /newNode_143

    state: newNode_143
        EndSession:

    state: newNode_144
        script:
            sendMessage($session.chatid,$session.msg,$session.keyboard=[], $session.keyboard_opt=[], $session.parse_prevew = ['html',false])
        # Transition /newNode_147
        go!: /newNode_145

    state: newNode_145
        a: sendMessage({{$session.chatid}},{{$session.msg}},{{$session.keyboard}}=[], {{$session.keyboard_opt}}=[], {{$session.parse_prevew}} = ['html',false])
        script:
            $reactions.timeout({interval: _.template('5 seconds', {variable: '$session'})($session), targetState: '/newNode_120'});

    state: newNode_67
        a: Между первой и второй - перерывчик небольшой!
        go!: /newNode_161

    state: newNode_161
        EndSession:

    state: newNode_69
        a: Всегда пожалуйста внучок!
        go!: /newNode_70

    state: newNode_70
        EndSession:

    state: newNode_136
        HttpRequest:
            url = http://blynk-cloud.com/6pJD1oNVMeHQOLXOBgPJ_ltFVjXK3mFr/update/V2?value=1
            method = GET
            body = 
            okState = /newNode_25
            errorState = /newNode_25
            timeout = 0
            headers = []
            vars = []

    state: newNode_135
        a:  Водомерка для iPhone
            https://pombur.github.io/vodomerka/ || html = "Водомерка для iPhone<br><a href=\"https://pombur.github.io/vodomerka/\">https://pombur.github.io/vodomerka/</a><br>", htmlEnabled = true
        go!: /newNode_175

    state: newNode_175
        EndSession:

    state: newNode_138
        a: Как добавить иконку на экран Домой || html = "<a href=\"https://youtu.be/GLBjRnJwUXQ\">Как добавить иконку на экран Домой</a>", htmlEnabled = true
        go!: /newNode_137

    state: newNode_137
        EndSession:

    state: newNode_148
        a: Заходи в гости.
        a: Резерв @Well_Drillin2gBot @Well_Drilling3_Bot
        buttons:
            {text: "@Well_DrillingBot", url: "https://t.me/Well_DrillingBot"}

    state: newNode_174
        EndSession:

    state: newNode_76
        random:
            a: 🤝
            a: 🖐
        go!: /newNode_77

    state: newNode_77
        EndSession:

    state: newNode_82
        a: ✊
        go!: /newNode_83

    state: newNode_83
        EndSession:

    state: newNode_149
        a:  Сенсей!!!
            {{$session.rawRequest.message.from.first_name}} хочет аби!!!
        # Transition /newNode_151
        go!: /newNode_33

    state: newNode_153
        a: Сообразим на троих?
        go!: /newNode_162
    @IntentGroup
        {
          "boundsTo" : "/newNode_153",
          "actions" : [ {
            "buttons" : [ ],
            "type" : "buttons"
          } ],
          "global" : false
        }
    state: newNode_162
        state: 1
            intent: /sys/aimylogic/ru/agreement

            go!: /newNode_155

        state: 2
            intent: /sys/aimylogic/ru/negation

            go!: /newNode_82

        state: Fallback
            event: noMatch
            go!: /newNode_163
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_162",
                name: "newNode_162 buttons",
                handler: function($context) {
                }
            });

    state: newNode_155
        if: $session.alcash1 = $session.rawRequest.message.from.first_name
            go!: /newNode_154
        else:
            go!: /newNode_76

    state: newNode_154
        a:  {{$session.alcash1}} Разливающий.\n
            Кто ещё?
        go!: /newNode_169
    @IntentGroup
        {
          "boundsTo" : "/newNode_154",
          "actions" : [ {
            "buttons" : [ {
              "name" : "Я",
              "transition" : "/newNode_156"
            } ],
            "comments" : [ ],
            "nameLocator" : {
              "filename" : "src/convert.sc",
              "line" : 1100,
              "col" : 9
            },
            "valueLocator" : {
              "filename" : "src/convert.sc",
              "line" : 1100,
              "col" : 17
            },
            "type" : "buttons"
          } ],
          "global" : false
        }
    state: newNode_169
        state: 1
            intent: /sys/aimylogic/ru/agreement

            go!: /newNode_156

        state: 2
            intent: /sys/aimylogic/ru/negation

            go!: /newNode_82

        state: Fallback
            event: noMatch
            go!: /newNode_167
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_169",
                name: "newNode_169 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Я"
                    , transition: "/newNode_156"
                    },
                  ]);
                }
            });

    state: newNode_156
        if: $session.alcash2 = $session.rawRequest.message.from.first_name
            go!: /newNode_157
        else:
            go!: /newNode_76

    state: newNode_157
        a:  {{$session.alcash2}} Выпивающий.\n
            Кто третий?
        go!: /newNode_165
    @IntentGroup
        {
          "boundsTo" : "/newNode_157",
          "actions" : [ {
            "buttons" : [ {
              "name" : "Я",
              "transition" : "/newNode_159"
            } ],
            "comments" : [ ],
            "nameLocator" : {
              "filename" : "src/convert.sc",
              "line" : 1112,
              "col" : 9
            },
            "valueLocator" : {
              "filename" : "src/convert.sc",
              "line" : 1112,
              "col" : 17
            },
            "type" : "buttons"
          } ],
          "global" : false
        }
    state: newNode_165
        state: 1
            intent: /sys/aimylogic/ru/agreement

            go!: /newNode_159

        state: 2
            intent: /sys/aimylogic/ru/negation

            go!: /newNode_82

        state: Fallback
            event: noMatch
            go!: /newNode_170
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_165",
                name: "newNode_165 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Я"
                    , transition: "/newNode_159"
                    },
                  ]);
                }
            });

    state: newNode_159
        if: $session.alcash3 = $session.rawRequest.message.from.first_name
            go!: /newNode_158
        else:
            go!: /newNode_76

    state: newNode_158
        a:  {{$session.alcash1}} Наливает. \n
            {{$session.alcash2}} Нарезает. \n
            {{$session.alcash3}} Развлекает. \n
            Ну и за неё..... || html = "{{$session.alcash1}} Наливает.&nbsp;<br><br>{{$session.alcash2}} Нарезает.&nbsp;<br><br>{{$session.alcash3}} Развлекает.&nbsp;<br><br>Ну и за неё.....", htmlEnabled = true
        go!: /newNode_166
    @IntentGroup
        {
          "boundsTo" : "/newNode_158",
          "actions" : [ {
            "buttons" : [ {
              "name" : "За ЗаеБумбу!!!",
              "transition" : "/newNode_160"
            } ],
            "comments" : [ ],
            "nameLocator" : {
              "filename" : "src/convert.sc",
              "line" : 1126,
              "col" : 9
            },
            "valueLocator" : {
              "filename" : "src/convert.sc",
              "line" : 1126,
              "col" : 17
            },
            "type" : "buttons"
          } ],
          "global" : false
        }
    state: newNode_166
        state: 1
            intent: /sys/aimylogic/ru/agreement

            go!: /newNode_160

        state: 2
            intent: /sys/aimylogic/ru/negation

            go!: /newNode_163

        state: Fallback
            event: noMatch
            go!: /newNode_172
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_166",
                name: "newNode_166 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "За ЗаеБумбу!!!"
                    , transition: "/newNode_160"
                    },
                  ]);
                }
            });

    state: newNode_160
        a: 🥃
        script:
            $reactions.timeout({interval: _.template('2 seconds', {variable: '$session'})($session), targetState: '/newNode_5'});

    state: newNode_163
        a: {{$session.rawRequest.message.from.first_name}}, немешай соображать нам.
        # Transition /newNode_164
        go!: /newNode_153

    state: newNode_167
        a: {{$session.rawRequest.message.from.first_name}}, немешай соображать нам.
        # Transition /newNode_168
        go!: /newNode_154

    state: newNode_170
        a: {{$session.rawRequest.message.from.first_name}}, немешай соображать нам.
        # Transition /newNode_171
        go!: /newNode_157

    state: newNode_172
        a: О..., {{$session.rawRequest.message.from.first_name}} говорит тост и бежит за добавкой.
        # Transition /newNode_173
        go!: /newNode_158