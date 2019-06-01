# 윷놀이 게임 (2019 Spring, Team5)
중앙대학교 2019년 1학기 휴먼 ICT 소프트웨어공학 01분반
텀프로젝트 Team5의 윷놀이 게임입니다.  

## Build instructions

1. 이 레포지토리를 클론 또는 다운로드 합니다.

2. 이클립스 / IntelliJ / VSCode에서 전체 폴더를 Import하여 실행합니다.  

### First Case: Eclipse
뷰의 JFrame에서 한글을 사용하기에 인코딩이 깨질 가능성이 있습니다. 빌드 및 실행 전에 다음의 절차를 따라주십시오.  
 1. window - preferences - general - workspace로 들어갑니다.
 2. 인코딩을 default에서 other...로 바꾸고, UTF-8로 설정해줍니다.
 3. 이클립스를 재실행합니다.<br>
 
GUI_main.java가 main class가 됩니다. 빌드 및 실행하시면 됩니다.

### Second Case: IntelliJ
GUI_main.java 파일이 main클래스를 가지고 있습니다. 정상적으로 빌드 및 실행하실 수 있습니다.


### Third Case: VSCode
VSCode에서 java 파일을 빌드 및 실행하기 위해서는 VSCode의 Extension이 필요합니다. MicroSoft에서 제공하는 **Java Extension Pack**을 설치하시기 바랍니다.   
다음과 같이 `launch.json`을 작성한뒤, 실행합니다.
```json
{
    "version": "0.2.0",
    "configurations": [
        {
            "type": "java",
            "name": "CodeLens (Launch) - GUI_main",
            "request": "launch",
            "mainClass": "Controller.GUI_main"
        },
        {
            "type": "java",
            "name": "Debug (Launch) - Current File",
            "request": "launch",
            "mainClass": "Controller.GUI_main"
        }
    ]
}
```  
만약 실행에 어려움이 있다면, `lanch.json`과 같은 폴더에 다음과 같은 내용의 `settings.json`을 추가해주시기 바랍니다.
```json
{
    "files.exclude": {
        "**/.classpath": true,
        "**/.project": true,
        "**/.settings": true,
        "**/.factorypath": true
    },
    "java.home": "YOUR JDK PATH"
}
```  
## Team Members & Role  
- 박상현 (20154637) : **HEAD**, View Development
- 박성훈 (20155500) : Controller Development
- 임동규 (20153366) : Model Development  
<br>
전체 분석/설계 및 문서화는 팀원 전원이 다함께 진행
