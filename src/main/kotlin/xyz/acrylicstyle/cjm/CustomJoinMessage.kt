package xyz.acrylicstyle.cjm

import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.plugin.java.JavaPlugin

class CustomJoinMessage: JavaPlugin(), Listener {
    private var joinMessageSuffix: String? = null

    override fun onEnable() {
        server.pluginManager.registerEvents(this, this)
        joinMessageSuffix = config.getString("joinMessageSuffix", null)
    }

    @EventHandler
    fun onPlayerJoin(e: PlayerJoinEvent) {
        if (joinMessageSuffix != null) {
            e.joinMessage = "${ChatColor.YELLOW}${e.player.name} ${ChatColor.translateAlternateColorCodes('&', joinMessageSuffix)}"
        }
    }
}
