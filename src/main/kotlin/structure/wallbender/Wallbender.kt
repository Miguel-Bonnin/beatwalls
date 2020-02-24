package structure.wallbender

import structure.WallStructure
import structure.helperClasses.SpookyWall

fun WallStructure.bendWalls(walls: List<SpookyWall>): List<SpookyWall> {
    var l = walls.map { it.copy() }
    l = adjust(l)
    l = reverse(l)
    l = speeder(l)
    l = color(l)
    l = mirror(l)
    return l
}

fun WallStructure.generateBendAndRepeatWalls(): List<SpookyWall> {
    var l = this.generateWalls()
    l= this.bendWalls(l)
    l = this.repeat(l)
    return l
}
