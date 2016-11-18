package grenouilloland.modele;




/**
 * Enum TypeElement.
 * @author Alexis Prevost Mayhen
 * @author Guillaume Drouart
 * @author Lucas Gouedant
 * @author Nicolas Vatel
 */
public enum TypeElement{

	NENUPHAR{
        @Override
		public void effetSurGrenouille(Grenouille gr)
		{
			//rien
		}
	},

	NENUPHARIMMORTEL{
        @Override
		public void effetSurGrenouille(Grenouille gr)
		{
			//rien
		}
	},

	EAU{
        @Override
		public void effetSurGrenouille(Grenouille gr)
		{
			gr.mourir();
		}
	},

	NENUPHARVENENEUX{
        @Override
		public void effetSurGrenouille(Grenouille gr)
		{
			if(gr.estMalade())
			{
				gr.mourir();
			}
			else
			{
				gr.estMalade();
				gr.setPtVie(gr.getPtVie()/2);
			}
		}
	},

	NENUPHARNUTRITIF{
        @Override
		public void effetSurGrenouille(Grenouille gr)
		{
			gr.setPtVie(gr.getPtVie()+1);
			gr.guerir();
		}
	},

	NENUPHARDOPANT{
        @Override
		public void effetSurGrenouille(Grenouille gr)
		{
			gr.setPtVie(gr.getPtVie()*2);
			gr.guerir();
		}
	},

	NENUPHARMORTEL{
        @Override
		public void effetSurGrenouille(Grenouille gr)
		{
			gr.mourir();
		}
	};
	public abstract void effetSurGrenouille(Grenouille gr);

}

