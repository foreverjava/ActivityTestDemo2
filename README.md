1.手动创建活动
首先我们创建一个名为ActivityTestDemo的项目。
注意到，既然是手动创建活动，我们在Add an Activity Mobile这个环节就要选择Add No Activity,如下图所示

然后点击finish完成这个创建，进入到项目主界面，然后打开app→src→
main→java→com.example.activitytestdemo,你会发现这个包下面并没有MainActivity,这是为什么呢？因为我们刚才添加的是一个没有活动的项目，如下图所示

接下来我们就进入正题，创建活动了.鼠标右键点击com.example.activitytestdemo包→New→Activity→Empty Activity,如下图所示

会弹出一个创建活动的界面，如下图所示
这里注意到，不要勾选Generate Layout File 和Launcher Activity

为了区别之前的MainActivity,我们将活动的名字改为FirstActivity(Generate Layout File默认是勾选的，代表会自动为我们的FirstActivity创建一个对应的布局文件，而勾选Launcher Activity表示会自动将FirstActivity设置为当前项目的主活动，这里都不勾选，后面再创建布局和设置活动。而勾选Backwards Compatibility(AppCompat)表示会为项目启动用下兼容的模式，这个要勾选上)，然后点击Finish完成创建。

2.创建布局和加载布局
鼠标右键点击res→New→Directory来创建一个名为layout目录。如下图所示

接着我们右键点击layout目录→New→Layout resource file,会弹出一个新建布局资源文件的窗口，我们将这个布局文件命名为first_layout对应刚才创建的活动，根元素就默认选择为LinearLayout(表示线性布局),点击OK完成创建，如下图所示


这个界面是Android Studio为我们提供的可视化布局编辑器，你可以在屏幕的中间预览当前的布局，窗口最下方有两个切换卡，Desigr和Text。Desigr是当前的可视化布局编辑器，你可以通过拖动控件的方式来编辑布局，但并不推荐这样做(适用于快速开发)，Text是通过XML文件的方式来编辑布局的，现在点一下Text进行切换。里面的代码如下:
可以看到里面有一个LinearLayout元素，这是一个布局，它现在是作为主布局的(也是父布局，它的里面还可以在嵌套其他的布局)，现在我们在其中添加一个按钮，如下所示：

这里添加了一个Button元素，里面有几个属性，我们来看一下，首先是android:id是给当前的元素定义一个唯一标识符(就是给这个按钮一个编号，意思跟9527差不多，之后就是通过这个编号来对这个按钮进行编写动作)，android:layout_width指定当前元素的宽度，这是使用match_parent表示让当前元素和父元素(也就是LinearLayout)一样宽。android:layout_height指定当前元素的高度，这是使用wrap_content表示当前元素的高度只要刚好能包含里面的内容就行。android:text指定了元素中显示的文字内容。如下图所示

现在布局创建好了，我们去活动中加载它，打开FirstActivity,在onCreate()方法中加入如下代码


可以看到已经增加了代码，并在后面注释了，如果你是单行代码可以在代码的上进行注释或者放在代码的后面(视代码长短来定，注意美观，注释代码是一个良好编码习惯)，我们这里调用了**setContentView()方法给当前的活动加载一个布局，在这个方法中传入布局文件的id,项目中添加的任何资源都会在R文件中生成一个相应资源的id,所以我们用R.layout.first_layout来找到这个布局文件，并通过setContentView()**方法来引用它。

2.1 在AndroidManifest文件中注册

之前的HelloWorld中我们提到，所有的活动都要在AndroidManifest.xml中进行注册才能生效，而实际上FiirstActivity已经注册过了，我们打开AndroidManifest.xml看一下，代码如下所示

可以看到标签内有一个已经注册好的 就是**.FirstActivity**这是一个缩写，全称是com.example.activitytestdemo.FirstActivity,因此我们就不需要注册活动了，不过这仅仅是注册了活动，但还没有给程序配置主活动，所以还是不能运行的，然后我们来配置主活动。
可以看到中间的部分就是新增打代码，这里我们给项目换了一个标题android:label=“This is FirstActivity”,而配置主活动只需要在里面放这两行代码就可以了，如下所示

已经修改好了，平时我们使用APP时，都会有一些提示(Toast),接下来我们来看一下怎么用，

2.2 Toast的使用

	介绍：Toast是Android系统提供的一种非常好的提醒方式，在程序中可以使用它将一些短小的信息通知给用户，过一会又会自动消失，并且不会占用任何屏幕空间，现在来试试吧。
	首先我们需要定义个弹出Toast的触发点(==也就是发生条件，什么情况下产生这个Toast提示==)，这里我们以点击按钮作为触发点，代码如下：


为了避免不必要的麻烦，我把所有代码都写上，我们先实例化这个按钮，然后在这个按钮的setOnClickListener()方法为按钮注册一个监听器，点击按钮就会执行监听器中的方法onClick()方法，所以我们的Toast要放在这个onClick()方法里面才行。
Toast首先通过静态方法makeText()创建出一个Toast对象，然后调用show()将Toast显示出来，我们看到makeText()方法中传递了三个参数，第一个参数是Context(也就是Toast要求的上下文参数)，而活动本身就是一个Context对象,因此这里直接传入FirstActivity.this即可，第二个参数是Toast显示的文本内容，第三个参数是Toast显示时长，有两个内置常量可以选择Toast.LENGTH_SHORT和Toast.LENGTH.LONG,建议你用第一个短时间的(因为第二个显示的时间较长，在哪里一动不动的，又不能直接关闭，好讨嫌的)，现在我们再运行一下，然后点击按钮，看看效果，如下图所示。

已经是有了，接下来我们来使用Menu(菜单)

2.3 Menu的使用

首先我们再res目录下新建一个menu文件夹，右击res目录→New→Dircetory,输入menu,建好menu目录后，再鼠标右击menu目录→New→Menu resource file,输入main,点击OK就创建好了(PS：创建目录及创建文件我不就截图了，都是基本操作了)，打开main.xml,代码如下
创建了两个菜单项，然后回到FirstActivity中重写onCreateOptionsMenu()方法，快捷键为Ctrl+O。

通过getMenuInflater()方法能够得到MenuInflater对象，再调用它的inflate()方法就可以给当前活动创建菜单了。inflate()方法接收两个参数，第一个参数用于指定我们通过那个资源文件来创建菜单，这里传入我们创建的main.xml文件 (还是通过R.menu.main),第二个参数用于指定我们的菜单项将添加到哪一个Menu对象当中，这里直接使用onCreateOptionsMenu()方法中传入的menu参数。然后返回true,表示允许创建的菜单显示出来，改成false,就不会显示出来。
当然现在的菜单也只能是一个摆设，我们还需要让它能够相应用户操作，所以我们还需要在FirstActivity中重写onOptionsItemSelected()方法：
