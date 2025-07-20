class Car (val engine: Engine,val wheel: Wheel){


    fun carStart(){
        engine.start()
        wheel.move()
    }
}