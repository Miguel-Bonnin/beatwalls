package structure

import org.junit.Test

import org.junit.Assert.*
import structure.helperClasses.*

class CopyTest {

    @Test
    fun copyWalls() {
        val ws = Line()
        ws.spookyWalls = arrayListOf(
            SpookyWall(1.0,0.0,32.3,23.4,124.2,241.0, red),
            SpookyWall(1.0,0.0,32.3,23.4,124.2,221.0, blue)
        )
        val expected = arrayListOf(
        SpookyWall(1.0,0.0,32.3,23.4,124.2,241.0, red),
        SpookyWall(1.0,0.0,32.3,23.4,124.2,221.0, blue)
        )
        val actual = ws.copyWalls()
        assertEquals(expected,actual)
        assertEquals(expected.first(),actual.first())
        assertFalse(expected === actual)
        assertFalse(expected.first() === actual.first())
    }

    @Test
    fun deepCopy() {
        val ws = Define()
        ws.structures = listOf(Line().also { it.spookyWalls.add(SpookyWall(0.0,0.0,0.0,0.0,0.0,0.0, cyan)) })
        ws.spookyWalls = arrayListOf(
            SpookyWall(1.0,0.0,32.3,23.4,124.2,241.0, red),
            SpookyWall(1.0,0.0,32.3,23.4,124.2,221.0, blue)
        )
        val wl = ws.deepCopy()
        assert(ws == wl)
        assertFalse(ws === wl)
        assert(ws.spookyWalls == wl.spookyWalls)
        assertFalse(ws.spookyWalls === wl.spookyWalls)
        assertNotEquals(ws.structures.first(), wl)
        assertFalse(ws.structures.first() === wl)
    }
}